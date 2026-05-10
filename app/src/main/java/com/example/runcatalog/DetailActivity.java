package com.example.runcatalog;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    ImageView imgDetail;
    TextView txtName, txtBrand, txtPrice;
    Button btnFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgDetail = findViewById(R.id.imgDetail);
        txtName = findViewById(R.id.txtName);
        txtBrand = findViewById(R.id.txtBrand);
        txtPrice = findViewById(R.id.txtPrice);
        btnFavorite = findViewById(R.id.btnFavorite);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String brand = intent.getStringExtra("brand");
        String price = intent.getStringExtra("price");
        int image = intent.getIntExtra("image", 0);

        txtName.setText(name);
        txtBrand.setText(brand);
        txtPrice.setText(price);
        imgDetail.setImageResource(image);

        btnFavorite.setOnClickListener(v -> {

            Intent pindah =
                    new Intent(DetailActivity.this,
                            FavoriteActivity.class);

            startActivity(pindah);
        });
    }
}