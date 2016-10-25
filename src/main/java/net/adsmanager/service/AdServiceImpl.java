package net.adsmanager.service;


import net.adsmanager.dao.AdDao;
import net.adsmanager.model.Ad;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by FlipBook TP300LD on 24.10.2016.
 */
@Service
public class AdServiceImpl implements AdService{

    private AdDao adDao;
    public void setAdDao(AdDao adDao){ this.adDao = adDao; }

    @Override
    @Transactional
    public void addAd(Ad ad) {
        this.adDao.addAd(ad);
    }

    @Override
    public void updateAd(Ad ad) {
        this.adDao.updateAd(ad);
    }

    @Override
    public void removeAd(int id) {
        this.adDao.removeAd(id);
    }

    @Override
    public Ad getAdById(int id) {
        return this.adDao.getAdById(id);
    }

    @Override
    public List<Ad> listAds() {
        return this.adDao.listAds();
    }
}
