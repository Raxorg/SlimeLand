package com.epicness.slimeland;

import com.epicness.firebase.CoreFirestore;
import com.epicness.firebase.FirebaseUtils;
import com.epicness.firebase.ResultListener;
import com.epicness.slimeland.menu.stuff.Player;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Source;

import java.util.Map;

public class AndroidFirestore implements CoreFirestore {

    private final FirebaseFirestore database;
    private final DocumentReference players, colors;

    public AndroidFirestore() {
        database = FirebaseFirestore.getInstance();
        CollectionReference gameInfo = database.collection("gameInfo");
        players = gameInfo.document("players");
        colors = gameInfo.document("colors");
    }

    @Override
    public void registerPlayer(Player player, ResultListener<Void> successListener, ResultListener<String> colorsListener,
                               ResultListener<String> errorListener) {
        database.runTransaction(transaction -> {
            // Check if there's a player with the chosen name
            DocumentSnapshot playersSnapshot = transaction.get(players);
            if (playersSnapshot.getString(player.getName()) != null) {
                errorListener.onResult("Duplicate name");
                return false;
            }
            // Check if there's a player with the chosen colors
            DocumentSnapshot colorsSnapshot = transaction.get(colors);
            String availableColors = colorsSnapshot.getString("availableColors");
            if (availableColors == null || availableColors.equals("")) {
                errorListener.onResult("No colors available");
                return false;
            }
            String newAvailableColors = FirebaseUtils.extractColorPair(player.getColors(), availableColors);
            colorsListener.onResult(newAvailableColors);
            if (availableColors.equals(newAvailableColors)) {
                errorListener.onResult("Colors unavailable");
                return false;
            }
            // Name and colors available, update database with the new player
            transaction.update(colors, "availableColors", newAvailableColors);
            String playerInfo = player.getColors() + ","
                    + player.getSlimeQuantity() + ","
                    + player.getSlimeStrength() + ","
                    + player.getSlimeAgility();
            transaction.update(players, player.getName(), playerInfo);
            return true;
        }).addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                errorListener.onResult("Internet error");
            }
            if (task.getResult() == null || !task.getResult()) {
                return;
            }
            successListener.onResult(null);
        });
    }

    public void fetchPlayerData(ResultListener<Map<String, Object>> playerDataListener) {
        fetchData(players, playerDataListener);
    }

    private void fetchData(DocumentReference documentReference, ResultListener<Map<String, Object>> dataListener) {
        documentReference.get(Source.SERVER).addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                dataListener.onResult(null);
                return;
            }
            DocumentSnapshot snapshot = task.getResult();
            if (snapshot == null) {
                dataListener.onResult(null);
                return;
            }
            Map<String, Object> dataMap = snapshot.getData();
            dataListener.onResult(dataMap);
        });
    }

    @Override
    public void incrementArmy(String playerName, ResultListener<Boolean> successListener) {
        database.runTransaction(transaction -> {
            DocumentSnapshot playersSnapshot = transaction.get(players);
            String playerInfo = playersSnapshot.getString(playerName);
            if (playerInfo == null) {
                return false;
            }
            String[] playerInfos = playerInfo.split(",");
            playerInfos[1] = String.valueOf(Integer.parseInt(playerInfos[1]) + 1);
            String newPlayerInfo = "";
            for (int i = 0; i < playerInfos.length; i++) {
                newPlayerInfo = newPlayerInfo.concat(playerInfos[i]);
                if (i != playerInfos.length - 1) {
                    newPlayerInfo = newPlayerInfo.concat(",");
                }
            }
            transaction.update(players, playerName, newPlayerInfo);
            return true;
        }).addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                successListener.onResult(false);
                return;
            }
            if (task.getResult() == null || !task.getResult()) {
                successListener.onResult(false);
                return;
            }
            successListener.onResult(true);
        });
    }

    public void addDocument(CollectionReference collectionReference, String documentPath, Object data,
                            String errorMessage, ResultListener<Boolean> listener) {
        collectionReference.document(documentPath).set(data).addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                Exception exception = task.getException();
                if (exception == null) {
                    return;
                }
                System.out.println(errorMessage + ": " + task.getException().getMessage());
            }
            listener.onResult(task.isSuccessful());
        });
    }
}