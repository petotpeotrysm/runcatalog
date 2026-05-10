package com.example.runcatalog;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CatalogActivity extends AppCompatActivity {

    RecyclerView recyclerShoes;
    EditText etSearch;
    Button btnAZ, btnZA;

    ArrayList<Shoes> listShoes;
    ShoesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        recyclerShoes = findViewById(R.id.recyclerShoes);
        etSearch = findViewById(R.id.etSearch);
        btnAZ = findViewById(R.id.btnAZ);
        btnZA = findViewById(R.id.btnZA);

        // DATA SHOES
        listShoes = new ArrayList<>();

        listShoes.add(new Shoes(
                "Nike Pegasus 41",
                "Nike",
                "Rp 2.100.000",
                R.drawable.nike1));

        listShoes.add(new Shoes(
                "Adidas Ultraboost",
                "Adidas",
                "Rp 3.200.000",
                R.drawable.adidas1));

        listShoes.add(new Shoes(
                "Nike Revolution 7",
                "Nike",
                "Rp 1.200.000",
                R.drawable.nike2));

        listShoes.add(new Shoes(
                "Adidas Adizero",
                "Adidas",
                "Rp 2.800.000",
                R.drawable.adidas2));
        listShoes.add(new Shoes(
                "Nike Vomero 18",
                "Nike",
                "Rp 2.500.000",
                R.drawable.nike3));

        listShoes.add(new Shoes(
                "Adidas Supernova",
                "Adidas",
                "Rp 2.300.000",
                R.drawable.adidas3));

        listShoes.add(new Shoes(
                "Nike Alphafly",
                "Nike",
                "Rp 4.500.000",
                R.drawable.nike4));

        listShoes.add(new Shoes(
                "Adidas Boston 12",
                "Adidas",
                "Rp 3.100.000",
                R.drawable.adidas4));

        listShoes.add(new Shoes(
                "Nike Infinity Run",
                "Nike",
                "Rp 2.700.000",
                R.drawable.nike5));
        listShoes.add(new Shoes(
                "Adizero Prime X3 Strung",
                "Adidas",
                "Rp 4.100.000",
                R.drawable.adidas5));
        // SETUP RECYCLER VIEW
        recyclerShoes.setLayoutManager(
                new LinearLayoutManager(this));

        adapter = new ShoesAdapter(this,
                listShoes);

        recyclerShoes.setAdapter(adapter);

        Log.d("42430022",
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

                filterData(s.toString());

                Log.d("42430022",
                        "Searching: " + s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // SORT A-Z
        btnAZ.setOnClickListener(v -> sortAZ());

        // SORT Z-A
        btnZA.setOnClickListener(v -> sortZA());
    }

    // FILTER SEARCH
    private void filterData(String text){

        ArrayList<Shoes> filteredList =
                new ArrayList<>();

        for(Shoes shoes : listShoes){

            if(shoes.getName().toLowerCase()
                    .contains(text.toLowerCase())){

                filteredList.add(shoes);
            }
        }

        adapter = new ShoesAdapter(this,
                filteredList);

        recyclerShoes.setAdapter(adapter);
    }

    // SORT A-Z
    private void sortAZ(){

        try {

            Collections.sort(listShoes,
                    Comparator.comparing(Shoes::getName));

            adapter.notifyDataSetChanged();

            Log.d("42430022",
                    "Sorting A-Z berhasil");

        } catch (Exception e){

            Log.e("42430022",
                    "Error sorting A-Z: "
                            + e.getMessage());
        }
    }

    // SORT Z-A
    private void sortZA(){

        try {

            Collections.sort(listShoes,
                    (a, b) ->
                            b.getName().compareTo(a.getName()));

            adapter.notifyDataSetChanged();

            Log.d("42430022",
                    "Sorting Z-A berhasil");

        } catch (Exception e){

            Log.e("42430022",
                    "Error sorting Z-A: "
                            + e.getMessage());
        }
    }
}