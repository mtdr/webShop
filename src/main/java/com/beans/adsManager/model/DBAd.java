package com.beans.adsManager.model;

/**
 * Created by FlipBook TP300LD on 12.11.2016.
 */
public class DBAd {
    private int id;
    private int price;
    private String title;
    private String owner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "ad=" + id +
                ", adTitle='" + title+ '\'' +
                ", owner='" + owner + '\'' +
                ", price=" + price +
                '}';
    }
}
