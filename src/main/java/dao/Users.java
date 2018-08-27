package dao;

import models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Users {

    long insertUser(User user) throws SQLException;
    ResultSet validateUser(String username, String password) throws SQLException;
    ResultSet getAllUsers() throws SQLException;
    int editPassword(String password, String username, String oldPassword);
    int editUsername(String newUsername, String oldUsername) throws SQLException;
    ResultSet findOne(String username) throws SQLException;

}
