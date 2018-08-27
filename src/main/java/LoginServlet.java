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

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
          ResultSet match = DaoFactory.getUsersDao().validateUser(username, password);
          User newUser = new User(
                  match.getString("email"),
                  match.getString("username"),
                  match.getString("password")
          );
          request.getSession().setAttribute("user", newUser);
          ResultSet matchUser = DaoFactory.getUsersDao().findOne(username);
          long currentId = matchUser.getInt("id");
          System.out.println(currentId);
          List<Ad> usersAds = DaoFactory.getAdsDao().getCurrUsersAds(currentId);
          request.getSession().setAttribute("usersAds", usersAds);
          for (Ad ad: usersAds) {
              System.out.println(ad.getTitle());
          }
          response.sendRedirect("/profile");
          } catch (NullPointerException e) {
            response.sendRedirect("/login");
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

    }
}
