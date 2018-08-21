import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NamePageServlet", urlPatterns = "/name")
public class NamePageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        firstName = firstName.toUpperCase().charAt(0) + firstName.substring(1).toLowerCase();
        request.setAttribute("firstName", firstName);
        request.getRequestDispatcher("/welcomeName.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/NameForm.jsp").forward(request, response);
    }
}
