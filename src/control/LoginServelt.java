package control;

import factory.DAOFactory;

import javax.servlet.RequestDispatcher;
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
        String id = req.getParameter("id");
        String statue = null;
        String password = req.getParameter("password");
        //放回值为null登陆失败
        String name = DAOFactory.getPersonDAOimpInstance().loginCheck(id, password);
        RequestDispatcher requestDispatcher = null;
        statue = name;
        req.setAttribute("name", statue);
        requestDispatcher = req.getRequestDispatcher("login_check.jsp");
        requestDispatcher.forward(req, resp);
    }
    public void doPost(HttpServletRequest req,
                       HttpServletResponse resp)
            throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
