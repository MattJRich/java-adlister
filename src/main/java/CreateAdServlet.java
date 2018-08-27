import dao.DaoFactory;
import models.Ad;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        System.out.println(title);
        System.out.println(description);
        User currentUser = (User) request.getSession().getAttribute("user");
        String currentUsername = currentUser.getUsername();
        ResultSet userRecord = DaoFactory.getUsersDao().findOne(currentUsername);
        Ad newAdd = new Ad(
                userRecord.getInt("id"),
                title,
                description
        );
        DaoFactory.getAdsDao().insertAd(newAdd);

            ResultSet matchUser = DaoFactory.getUsersDao().findOne(currentUsername);
            long currentId = matchUser.getInt("id");
            System.out.println(currentId);
            List<Ad> usersAds = DaoFactory.getAdsDao().getCurrUsersAds(currentId);
            request.getSession().removeAttribute("usersAds");
            request.getSession().setAttribute("usersAds", usersAds);
            for (Ad ad: usersAds) {
                System.out.println(ad.getTitle());
            }
            response.sendRedirect("/profile");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            request.getRequestDispatcher("/WEB-INF/createAd.jsp").forward(request, response);
        } else {
            response.sendRedirect("/login");
        }

    }
}
