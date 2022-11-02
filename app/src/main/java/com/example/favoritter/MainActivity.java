package com.example.favoritter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lv_favoriteList;
    DataBaseHelper dbHelper;
    ArrayAdapter favoriteArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        lv_favoriteList = findViewById(R.id.lv_allFavorites);
        dbHelper = new DataBaseHelper(MainActivity.this);

        showFavoritesOnListView(dbHelper);
    }
    private void showFavoritesOnListView(DataBaseHelper dataBaseHelper2){
        favoriteArrayAdapter = new ArrayAdapter<FavoriteModel>(MainActivity.this, android.R.layout.simple_list_item_1, dbHelper.getUserFavorite());
        lv_favoriteList.setAdapter(favoriteArrayAdapter);
    }
}