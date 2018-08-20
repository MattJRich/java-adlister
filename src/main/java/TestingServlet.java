import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "TestingServlet", urlPatterns = "/test")
public class TestingServlet extends HttpServlet {
    int counter = 0;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("name");
        PrintWriter myPrint = res.getWriter();
        try {
            if (name.equalsIgnoreCase("matt")) {
                myPrint.println("Hello Matt!");

            } else {
                myPrint.println("Hello!");
            }
        } catch (NullPointerException e) {
            myPrint.println("Hello!");
        }
        res.setContentType("text/html");
        myPrint.println("<h1>How are you?</h1>");
        myPrint.println("Counter: " + counter);
        counter++;
    }




}
