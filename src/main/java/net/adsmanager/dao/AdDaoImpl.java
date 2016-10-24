package net.adsmanager.dao;

import net.adsmanager.model.Ad;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdDaoImpl implements AdDao{
    private static final Logger logger = LoggerFactory.getLogger(AdDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addAd(Ad ad) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(ad);
        logger.info("Ad successfully saved. Book details: " + ad);
    }

    @Override
    public void updateAd(Ad ad) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(ad);
        logger.info("Ad successfully update. Book details: " + ad);
    }

    @Override
    public void removeAd(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Ad ad = (Ad) session.load(Ad.class, new Integer(id));

        if(ad!=null){
            session.delete(ad);
        }
        logger.info("Ad successfully removed. Book details: " + ad);
    }

    @Override
    public Ad getAdById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Ad ad = (Ad) session.load(Ad.class, new Integer(id));
        logger.info("Book successfully loaded. Book details: " + ad);

        return ad;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Ad> listAds() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Ad> adList = session.createQuery("from Ad").list();

        for(Ad ad: adList){
            logger.info("Ad list: " + ad);
        }

        return adList;
    }
}
