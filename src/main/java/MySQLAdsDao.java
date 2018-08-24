import com.mysql.cj.jdbc.Driver;
import java.sql.*;

import javax.xml.transform.Result;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection myConn;


    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            this.myConn = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Ad> all()  {
        List<Ad> ads = new ArrayList<>();
        try {
            Statement myStmt = myConn.createStatement();
            String findAllQuery = "SELECT * FROM ads";
            ResultSet myRs = myStmt.executeQuery(findAllQuery);
             ads = buildAdObjects(myRs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ads;
    }



    @Override
    public Long insert(Ad ad) throws SQLException {
//            String query = "INSERT INTO ads (user_id ,title, description) VALUES (" + ad.getUserId()+ ", '" + ad.getTitle() + "', '" + ad.getDescription() + "')";
        String query = "INSERT INTO ads (userId ,title, description) VALUES (" + ad.getUserId()+ ", '" + ad.getTitle() + "', '" + ad.getDescription() + "')";
            Statement stmt = myConn.createStatement();
            stmt.executeUpdate(query, stmt.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getLong(1);
            } else {
                throw new RuntimeException("error with insert");
            }
    }



    public List<Ad> buildAdObjects(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(
                    new Ad(
                            rs.getLong("id"),
                            rs.getLong("userId"),
                            rs.getString("title"),
                            rs.getString("description")
                    )
            );
        }
        return ads;
    }

}
