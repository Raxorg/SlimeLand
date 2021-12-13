package com.epicness.slimeland;

import androidx.annotation.NonNull;

import com.epicness.firebase.CoreFirestore;
import com.epicness.firebase.ResultListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AndroidFirestore implements CoreFirestore {

    private final CollectionReference players;

    public AndroidFirestore() {
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        players = database.collection("players");
    }

    @Override
    public void registerPlayer(String playerID, ResultListener<Boolean> listener) {
        Map<String, Object> user = new HashMap<>();
        user.put("PlayerID", playerID);
        players.add(user).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if (task.isSuccessful()) {

                } else {
                    Exception exception = task.getException();
                    if (exception == null) {
                        return;
                    }
                    System.out.println(task.getException().getMessage());
                }
            }
        });
    }
}