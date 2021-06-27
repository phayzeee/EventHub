package com.example.eventhub;

public class Decorator {

    int dec_img;
    private String dec_name, dec_price;

    public Decorator(int dec_img, String dec_name, String dec_price) {
        this.dec_img = dec_img;
        this.dec_name = dec_name;
        this.dec_price = dec_price;
    }

    public int getDec_img() {
        return dec_img;
    }

    public void setDec_img(int dec_img) {
        this.dec_img = dec_img;
    }

    public String getDec_name() {
        return dec_name;
    }

    public void setDec_name(String dec_name) {
        this.dec_name = dec_name;
    }

    public String getDec_price() {
        return dec_price;
    }

    public void setDec_price(String dec_price) {
        this.dec_price = dec_price;
    }
}
