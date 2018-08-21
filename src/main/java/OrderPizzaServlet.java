import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "OrderPizzaServlet", urlPatterns = "/pizza")
public class OrderPizzaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String pizzaSize = request.getParameter("pizzaSize");
        String[] toppings = request.getParameterValues("topping");
        request.setAttribute("name", name);
        request.setAttribute("address", address);
        request.setAttribute("pizzaSize", pizzaSize);
        request.setAttribute("toppings", toppings);
        request.getRequestDispatcher("/pizzaResults.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pizzaForm.jsp").forward(request, response);

    }
}
