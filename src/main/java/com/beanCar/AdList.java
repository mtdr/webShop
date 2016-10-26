package com.beanCar;

import java.util.ArrayList;

public class AdList {
    private static ArrayList<Ad> adList = new ArrayList();

    public static void addElem(Ad ad) {
        adList.add(ad);
    }
    public static void deleteList() {
        adList.clear();
        Ad.setCounter(0);
    }
    public static ArrayList<Ad> getAdList() {
        return adList;
    }
}
