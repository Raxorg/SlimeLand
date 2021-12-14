package com.epicness.slimeland;

import com.epicness.firebase.CoreFirestore;
import com.epicness.firebase.FirebaseUtils;
import com.epicness.firebase.ResultListener;
import com.epicness.slimeland.menu.stuff.Player;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class AndroidFirestore implements CoreFirestore {

    private final FirebaseFirestore database;
    private final CollectionReference gameInfo;

    public AndroidFirestore() {
        database = FirebaseFirestore.getInstance();
        gameInfo = database.collection("gameInfo");
    }

    @Override
    public void registerPlayer(Player player, ResultListener<Boolean> successListener, ResultListener<String> errorListener) {
        database.runTransaction(transaction -> {
            // Check if there's a player with the chosen name
            DocumentSnapshot playersSnapshot = transaction.get(gameInfo.document("players"));
            if (playersSnapshot.getString(player.getName()) != null) {
                errorListener.onResult("Duplicate name");
                return false;
            }
            // Check if there's a player with the chosen colors
            DocumentSnapshot colorsSnapshot = transaction.get(gameInfo.document("colors"));
            String availableColors = colorsSnapshot.getString("availableColors");
            if (availableColors == null || availableColors.equals("")) {
                errorListener.onResult("No colors available");
                return false;
            }
            String newAvailableColors = FirebaseUtils.extractColorPair(player.getColors(), availableColors);
            if (availableColors.equals(newAvailableColors)) {
                errorListener.onResult("Colors unavailable");
                return false;
            }
            // Name and colors available, update database with the new player
            transaction.update(gameInfo.document("colors"), "availableColors", newAvailableColors);
            transaction.update(gameInfo.document("players"), player.getName(), player.getColors());
            return true;
        }).addOnCompleteListener(task -> {
            if (task.getResult() == null) {
                return;
            }
            if (!task.isSuccessful()) {
                errorListener.onResult("Internet error");
            }
            successListener.onResult(task.getResult());
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