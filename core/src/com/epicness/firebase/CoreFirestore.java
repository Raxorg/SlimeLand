package com.epicness.firebase;

public interface CoreFirestore {

    void registerPlayer(String playerID, ResultListener<Boolean> listener);
}