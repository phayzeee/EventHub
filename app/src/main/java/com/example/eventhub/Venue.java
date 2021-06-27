package com.example.eventhub;

public class Venue {

    int venue_img;
    private String name_venue, price_venue;

    public Venue(int venue_img, String name_venue, String price_venue) {
        this.venue_img = venue_img;
        this.name_venue = name_venue;
        this.price_venue = price_venue;
    }

    public int getVenue_img() {
        return venue_img;
    }

    public void setVenue_img(int venue_img) {
        this.venue_img = venue_img;
    }

    public String getName_venue() {
        return name_venue;
    }

    public void setName_venue(String name_venue) {
        this.name_venue = name_venue;
    }

    public String getPrice_venue() {
        return price_venue;
    }

    public void setPrice_venue(String price_venue) {
        this.price_venue = price_venue;
    }


}
