package com.example.runcatalog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FavoriteActivity extends AppCompatActivity {

    EditText etNama;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        etNama = findViewById(R.id.etNama);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {

            String nama =
                    etNama.getText().toString();

            if(nama.isEmpty()){

                Toast.makeText(this,
                        "Nama tidak boleh kosong",
                        Toast.LENGTH_SHORT).show();

            }else{

                Toast.makeText(this,
                        "Data berhasil disimpan",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}