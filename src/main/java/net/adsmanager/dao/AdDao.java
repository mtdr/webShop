package net.adsmanager.dao;


import net.adsmanager.model.Ad;

import java.util.List;

public interface AdDao {

    public void addAd(Ad ad);

    public void updateAd(Ad ad);

    public void removeAd(int id);

    public Ad getAdById(int id);

    public List<Ad> listAds();
}
