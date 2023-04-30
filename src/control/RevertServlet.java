package control;

import factory.DAOFactory;
import vo.Revert;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/RevertServlet")
public class RevertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String statue=(String) req.getAttribute("statue");
        if(statue.isEmpty()){
            statue=req.getParameter("statue");
        }
        if("showAllRevert".equals(statue)){
            int id = (int)req.getAttribute("id");
            List<Revert> list = DAOFactory.getRevertDAOimpInstance().findAllRevertByMessageId(id);
            HttpSession session=req.getSession();
            session.setAttribute("revertList",list);
            RequestDispatcher requestDispatcher= req.getRequestDispatcher("delMessage.jsp");
            requestDispatcher.forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
