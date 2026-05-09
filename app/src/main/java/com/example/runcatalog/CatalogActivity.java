package com.example.runcatalog;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;

public class CatalogActivity extends AppCompatActivity {

    ListView listShoes;
    EditText etSearch;
    Button btnAZ, btnZA;

    String[] shoes = {
            "Nike Air Zoom Pegasus",
            "Nike Revolution 7",
            "Adidas Ultraboost",
            "Adidas Adizero",
            "Nike Structure 25"
    };

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        listShoes = findViewById(R.id.listShoes);
        etSearch = findViewById(R.id.etSearch);
        btnAZ = findViewById(R.id.btnAZ);
        btnZA = findViewById(R.id.btnZA);

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                shoes
        );

        listShoes.setAdapter(adapter);

        Log.d("230040039",
                "Catalog Dibuka");

        // SEARCH
        etSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s,
                                          int start,
                                          int count,
                                          int after) {

            }

            @Override
            public void onTextChanged(CharSequence s,
                                      int start,
                                      int before,
                                      int count) {

                adapter.getFilter().filter(s);

                Log.d("230040039",
                        "Searching: " + s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // BUTTON SORT A-Z
        btnAZ.setOnClickListener(v -> sortAZ());

        // BUTTON SORT Z-A
        btnZA.setOnClickListener(v -> sortZA());
    }

    // SORTING A-Z
    private void sortAZ(){

        try {

            Arrays.sort(shoes);

            adapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    shoes
            );

            listShoes.setAdapter(adapter);

            Log.d("230040039",
                    "Sorting A-Z berhasil");

        } catch (Exception e){

            Log.e("230040039",
                    "Error sorting A-Z: "
                            + e.getMessage());
        }
    }

    // SORTING Z-A
    private void sortZA(){

        try {

            Arrays.sort(shoes,
                    Collections.reverseOrder());

            adapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    shoes
            );

            listShoes.setAdapter(adapter);

            Log.d("230040039",
                    "Sorting Z-A berhasil");

        } catch (Exception e){

            Log.e("230040039",
                    "Error sorting Z-A: "
                            + e.getMessage());
        }
    }
}