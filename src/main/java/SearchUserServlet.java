import dao.DaoFactory;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "SearchUserServlet", urlPatterns = "/searchUser")
public class SearchUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            ResultSet match = DaoFactory.getUsersDao().findOne(username);
            User matchUser = new User(
                    match.getString("email"),
                    match.getString("username"),
                    match.getString("password")
            );
            request.setAttribute("matchUser", matchUser);
            request.getRequestDispatcher("/WEB-INF/searchedProfile.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/searchUser.jsp").forward(request, response);

    }
}
