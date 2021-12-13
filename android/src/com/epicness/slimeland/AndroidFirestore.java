package com.epicness.slimeland;

import com.epicness.firebase.CoreFirestore;
import com.epicness.firebase.ResultListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Transaction;

import java.util.HashMap;
import java.util.Map;

public class AndroidFirestore implements CoreFirestore {

    private final FirebaseFirestore database;
    private final CollectionReference players;
    private final CollectionReference gameInfo;

    public AndroidFirestore() {
        database = FirebaseFirestore.getInstance();
        players = database.collection("players");
        gameInfo = database.collection("gameInfo");
    }

    @Override
    public void registerPlayer(String playerID, ResultListener<Boolean> listener) {
        Map<String, Object> user = new HashMap<>();
        user.put("PlayerID", playerID);
        addDocument(players, playerID, user, "ERROR REGISTERING PLAYER", listener);
    }

    @Override
    public void claimColor(String color, ResultListener<Boolean> listener) {
        database.runTransaction((Transaction.Function<Void>) transaction -> {
            DocumentSnapshot snapshot = transaction.get(gameInfo.document("colors"));
            return null;
        });
    }

    public void addDocument(CollectionReference collectionReference, String documentPath, Map<String, Object> documentInfo,
                            String errorMessage, ResultListener<Boolean> listener) {
        collectionReference.document(documentPath).set(documentInfo).addOnCompleteListener(task -> {
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