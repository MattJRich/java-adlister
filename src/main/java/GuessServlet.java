import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GuessServlet", urlPatterns = "/guess")
public class GuessServlet extends HttpServlet {
    int number = (int) Math.floor(Math.random() * 100) + 1;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int guess = Integer.parseInt(request.getParameter("guessInput"));
            request.setAttribute("number", number);
            request.setAttribute("guess", guess);
            if (number == guess) {
                request.getRequestDispatcher("/correctNumber.jsp").forward(request, response);
                number = (int) Math.floor(Math.random() * 100) + 1;
            } else if (guess > number) {
                request.getRequestDispatcher("/goLower.jsp").forward(request, response);
            } else if (guess < number) {
                request.getRequestDispatcher("/goHigher.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.getRequestDispatcher("/invalidNumber.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/guessNumberPrompt.jsp").forward(request, response);
    }
}
