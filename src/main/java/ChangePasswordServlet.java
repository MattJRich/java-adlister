import dao.DaoFactory;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangePasswordServlet", urlPatterns = "/changePassword")
public class ChangePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newPassword = request.getParameter("password");
        User currentUser = (User) request.getSession().getAttribute("user");
        String username = currentUser.getUsername();
        String oldPassword = currentUser.getPassword();
        int rowsAffected = DaoFactory.getUsersDao().editPassword(newPassword, username, oldPassword);
        System.out.println(rowsAffected);
        response.sendRedirect("/profile");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            request.getRequestDispatcher("/WEB-INF/changePassword.jsp").forward(request, response);
        } else {
            response.sendRedirect("/login");
        }

    }
}
