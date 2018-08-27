package dao;

import com.mysql.cj.jdbc.Driver;
import models.Ad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class adsDao implements Ads {


    @Override
    public long insertAd(Ad ad) throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/testLister_db?serverTimezone=UTC&useSSL=false",
                "testList_user",
                "px"
        );
        String query = "INSERT INTO ads (user_id, title, description) VALUES (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, ad.getUserId());
        ps.setString(2, ad.getTitle());
        ps.setString(3, ad.getDescription());
        return ps.executeUpdate();
    }

    @Override
    public List<Ad> getCurrUsersAds(Long id) throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/testLister_db?serverTimezone=UTC&useSSL=false",
                "testList_user",
                "px"
        );
        String query = "SELECT * FROM ads WHERE user_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, id);
        ResultSet usersAds = ps.executeQuery();
        List<Ad> usersAdsList = new ArrayList<>();
        while (usersAds.next()) {
            Ad adObject = new Ad(
                    usersAds.getString("title"),
                    usersAds.getString("description")
            );
            usersAdsList.add(adObject);

        }
        return usersAdsList;
    }
}
