package com.example.runcatalog;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnMasuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMasuk = findViewById(R.id.btnMasuk);

        btnMasuk.setOnClickListener(v -> {

            Intent intent =
                    new Intent(MainActivity.this,
                            CatalogActivity.class);

            startActivity(intent);
        });
    }
}