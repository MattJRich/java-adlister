import com.mysql.cj.xdevapi.Session;
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
import java.sql.SQLIntegrityConstraintViolationException;

@WebServlet(name = "EditUsernameServlet", urlPatterns = "/editUsername")
public class EditUsernameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newUsername = request.getParameter("username");
        User currentUser = (User) request.getSession().getAttribute("user");
        String oldUsername = currentUser.getUsername();
        try {
            DaoFactory.getUsersDao().editUsername(newUsername, oldUsername);
            ResultSet updatedUser = DaoFactory.getUsersDao().findOne(newUsername);
            User newUser = new User(
                    updatedUser.getString("email"),
                    updatedUser.getString("username"),
                    updatedUser.getString("password")
            );
            request.getSession().removeAttribute("user");
            request.getSession().setAttribute("user", newUser);
            response.sendRedirect("/profile");
        } catch (SQLIntegrityConstraintViolationException e) {
            request.getRequestDispatcher("/WEB-INF/UsernameTaken.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            request.getRequestDispatcher("/WEB-INF/editUsername.jsp").forward(request, response);
        } else {
            response.sendRedirect("/login");
        }


    }
}
