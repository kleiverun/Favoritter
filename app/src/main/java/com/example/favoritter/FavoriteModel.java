package com.example.favoritter;

import androidx.annotation.NonNull;

public class FavoriteModel {
    private int userID,favoriteID;
    private String favoriteName;



    public FavoriteModel(int userID, int favoriteID, String favoriteName) {
        this.userID = userID;
        this.favoriteID = favoriteID;
        this.favoriteName = favoriteName;
    }

    @NonNull
    @Override
    public String toString() {
        return "FavoriteModel{" +
                "userID=" + userID +
                ", favoriteID=" + favoriteID +
                ", favoriteName='" + favoriteName + '\'' +
                '}';
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getFavoriteID() {
        return favoriteID;
    }

    public void setFavoriteID(int favoriteID) {
        this.favoriteID = favoriteID;
    }

    public String getFavoriteName() {
        return favoriteName;
    }

    public void setFavoriteName(String favoriteName) {
        this.favoriteName = favoriteName;
    }
}
