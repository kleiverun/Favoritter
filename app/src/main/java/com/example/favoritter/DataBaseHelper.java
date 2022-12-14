package com.example.favoritter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String FAVORITE_TABLE       = "FAVORITE_TABLE";
    public static final String COLUMN_USER_ID       = "USER_ID";
    public static final String COLUMN_FAVORITE_NAME = "FAVORITE_NAME";
    public static final String COLUMN_FAVORITE_ID   ="FAVORITE_ID";


    //Constructor.
    public DataBaseHelper(@Nullable Context context) {super(context, "favorite.db", null, 1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE "+ FAVORITE_TABLE +
                " ( " +COLUMN_FAVORITE_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                 +COLUMN_USER_ID+" INTEGER, "+COLUMN_FAVORITE_NAME+" TEXT )";

        db.execSQL(createTableStatement);
    }

    //Will be called whenever the database version changes.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {  }

    public List<FavoriteModel> getUserFavorite(){
        List<FavoriteModel> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM "+FAVORITE_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()){
            do{
                int favoriteID = cursor.getInt(0);
                int userID = cursor.getInt(1);
                String favoriteName = cursor.getString(2);

                FavoriteModel newFavorite = new FavoriteModel(userID,favoriteID,favoriteName);
                returnList.add(newFavorite);
            } while (cursor.moveToNext());
        }
        else {

        }

        cursor.close();
        db.close();
        return returnList;
    }
}
