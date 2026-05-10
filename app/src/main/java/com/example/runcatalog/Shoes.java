package com.example.runcatalog;

public class Shoes {

    String name, brand, price;
    int image;

    public Shoes(String name,
                 String brand,
                 String price,
                 int image) {

        this.name = name;
        this.brand = brand;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }
}