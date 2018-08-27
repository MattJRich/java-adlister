package dao;

import models.Ad;

import java.sql.SQLException;
import java.util.List;

public interface Ads {
    long insertAd(Ad ad) throws SQLException;
    List<Ad> getCurrUsersAds(Long id) throws SQLException;

}


