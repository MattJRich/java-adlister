package dao;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;
import models.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

public class UsersDao implements Users {



    @Override
    public long insertUser(User user) throws SQLException {
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/testLister_db?serverTimezone=UTC&useSSL=false",
                    "testList_user",
                    "px"
            );
            if (user.getEmail().equals("") || user.getUsername().equals("") || user.getPassword().equals("")) {
                throw new RuntimeException("one or more fields is blank");
            }
            String query = "INSERT INTO users (email, username, password) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ResultSet validateUser(String username, String password) throws SQLException {
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/testLister_db?serverTimezone=UTC&useSSL=false",
                    "testList_user",
                    "px"
            );
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (BCrypt.checkpw(password ,rs.getString("password"))) {
                    return rs;
                }
            }
            return null;

        } catch (SQLException e) {
            throw e;
        }
    }

    public ResultSet getAllUsers() throws SQLException {
        DriverManager.registerDriver(new Driver());
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/testLister_db?serverTimezone=UTC&useSSL=false",
                    "testList_user",
                    "px"
            );
            String query = "SELECT * FROM users";
            PreparedStatement ps = connection.prepareStatement(query);
            return ps.executeQuery();
        } catch (SQLException e) {
            throw e;
        }
    }

    public int editPassword(String newPassword, String username, String oldPassword) {
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/testLister_db?serverTimezone=UTC&useSSL=false",
                    "testList_user",
                    "px"
            );
            String query = "UPDATE users SET password = ? WHERE username = ? AND password = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newPassword);
            ps.setString(2, username);
            ps.setString(3, oldPassword);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }

    @Override
    public int editUsername(String newUsername, String oldUsername) throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/testLister_db?serverTimezone=UTC&useSSL=false",
                "testList_user",
                "px"
        );
        String query = "UPDATE users SET username = ? WHERE username = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, newUsername);
        ps.setString(2, oldUsername);
        return ps.executeUpdate();
    }

    public ResultSet findOne(String username) throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/testLister_db?serverTimezone=UTC&useSSL=false",
                "testList_user",
                "px"
        );
        String query = "SELECT * FROM users WHERE username = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs;
    }

}
