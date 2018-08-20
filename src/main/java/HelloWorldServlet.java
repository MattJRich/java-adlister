import javax.jws.WebService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello-world")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
        res.setContentType("text/html");
        PrintWriter myPrinter = null;
        try {
            myPrinter = res.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String name = req.getParameter("name");
            if (name != null) {
                myPrinter.println("<h1>Hello " + name + "</h1>");
            } else {
                myPrinter.println("<h1>Hello World</h1>");
            }
        } catch (NullPointerException e) {
            myPrinter.println("Hello World");
        }
    }
}

