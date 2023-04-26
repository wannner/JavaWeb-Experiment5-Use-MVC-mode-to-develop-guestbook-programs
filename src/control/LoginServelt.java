package control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServelt extends HttpServlet {
    public void doGet(HttpServletRequest req,
                      HttpServletResponse resp)
            throws ServletException, IOException {

    }
    public void doPost(HttpServletRequest req,
                       HttpServletResponse resp)
            throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
