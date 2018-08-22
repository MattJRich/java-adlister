import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentHomeServlet", urlPatterns = "/students")
public class StudentHomeServlet extends HttpServlet {
    private iStudents studentsDao = StudentsFactoryDao.getStudentsDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> allStudents = studentsDao.getAllStudents();
        request.setAttribute("allStudents", allStudents);
        request.getRequestDispatcher("/students/studentHome.jsp").forward(request, response);
    }
}
