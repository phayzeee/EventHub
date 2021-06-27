package com.example.eventhub;

public class Photo {

    int photo_img;
    private String photo_name, photo_price;

    public Photo(int photo_img, String photo_name, String photo_price) {
        this.photo_img = photo_img;
        this.photo_name = photo_name;
        this.photo_price = photo_price;
    }

    public int getPhoto_img() {
        return photo_img;
    }

    public void setPhoto_img(int photo_img) {
        this.photo_img = photo_img;
    }

    public String getPhoto_name() {
        return photo_name;
    }

    public void setPhoto_name(String photo_name) {
        this.photo_name = photo_name;
    }

    public String getPhoto_price() {
        return photo_price;
    }

    public void setPhoto_price(String photo_price) {
        this.photo_price = photo_price;
    }
}
