package com.example.eventhub;

public class Caterer {

    int cat_img;
    private String name_cat, price_cat;

    public Caterer(int cat_img, String name_cat, String price_cat) {
        this.cat_img = cat_img;
        this.name_cat = name_cat;
        this.price_cat = price_cat;
    }

    public int getCat_img() {
        return cat_img;
    }

    public void setCat_img(int cat_img) {
        this.cat_img = cat_img;
    }

    public String getName_cat() {
        return name_cat;
    }

    public void setName_cat(String name_cat) {
        this.name_cat = name_cat;
    }

    public String getPrice_cat() {
        return price_cat;
    }

    public void setPrice_cat(String price_cat) {
        this.price_cat = price_cat;
    }
}

