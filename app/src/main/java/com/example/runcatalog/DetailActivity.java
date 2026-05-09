package com.example.runcatalog;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    Button btnFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        btnFavorite = findViewById(R.id.btnFavorite);

        btnFavorite.setOnClickListener(v -> {

            Intent intent =
                    new Intent(DetailActivity.this,
                            FavoriteActivity.class);

            startActivity(intent);
        });
    }
}