package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                    .forward(request, response);
        } else {
            response.sendRedirect("/login");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
       User currentUser = (User) request.getSession().getAttribute("user");
       String username = currentUser.getUsername();
       User fullUser = DaoFactory.getUsersDao().findByUsername(username);
       Long userId = fullUser.getId();

        Ad ad = new Ad(
            userId,
            request.getParameter("title"),
            request.getParameter("description")
        );
        DaoFactory.getAdsDao().insert(ad);
        response.sendRedirect("/profile");

        try {
            User currentUserHere =  (User) request.getSession().getAttribute("user");
            long id = currentUserHere.getId();
            List<Ad> currentUserAds = null;
            currentUserAds = DaoFactory.getAdsDao().getListOfAds(id);
            request.getSession().removeAttribute("userAds");
            request.getSession().setAttribute("userAds", currentUserAds);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
