package net.adsmanager.service;

import net.adsmanager.model.Ad;

import java.util.List;

/**
 * Created by FlipBook TP300LD on 24.10.2016.
 */
public interface AdService {
    public void addAd(Ad ad);

    public void updateAd(Ad ad);

    public void removeAd(int id);

    public Ad getAdById(int id);

    public List<Ad> listAds();
}
