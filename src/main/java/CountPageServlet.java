import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CountPageServlet", urlPatterns = "/count")
public class CountPageServlet extends HttpServlet {
    int counter = 0;
    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        PrintWriter myPrinter = null;
        try {
            myPrinter = res.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        res.setContentType("text/html");
        try {
            String reset = req.getParameter("reset");
            if (reset != null) {
                counter = 0;
                try {
                    res.sendRedirect("/count");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                counter++;
            }
            myPrinter.println("<h1>Counter: " + counter + "</h1>");
        } catch (NullPointerException e) {
            counter++;
            myPrinter.println("<h1>Counter: " + counter + "</h1>");
        }
    }


}
