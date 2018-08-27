import dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AllUsersServlet" , urlPatterns = "/all")
public class AllUsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> usernames = new ArrayList<>();
        try {
            ResultSet rs = DaoFactory.getUsersDao().getAllUsers();
            while (rs.next()) {
                usernames.add(rs.getString("username"));
            }
           request.setAttribute("usernames", usernames);
            request.getRequestDispatcher("/WEB-INF/allUsers.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
