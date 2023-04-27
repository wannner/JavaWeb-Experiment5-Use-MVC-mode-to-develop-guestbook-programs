package control;

import factory.DAOFactory;
import vo.Message;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String statue = req.getParameter("statue");
        System.out.println(statue);
        if("deleteMessage".equals(statue)){
            int id=0;
            String messageId=req.getParameter("id");
            for (int i = 0; i < messageId.length(); i++) {
                id=id*10+(messageId.charAt(i)-'0');
            }
            System.out.println(id);
            DAOFactory.getMessageDAOimplInstance().deleteMessage(id);
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("saveMessage.jsp");
            requestDispatcher.forward(req,resp);
        }
        else if("showAllMessage".equals(statue)){
            List<Message> list = DAOFactory.getMessageDAOimplInstance().showAllMessage();
            HttpSession session=req.getSession();
            session.setAttribute("messageList",list);
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("messageBoard.jsp");
            requestDispatcher.forward(req,resp);
        }
        else if ("showMessage".equals(statue)){
            int id=0;
            String messageId=req.getParameter("id");
            for (int i = 0; i < messageId.length(); i++) {
                id=id*10+(messageId.charAt(i)-'0');
            }
            Message message = DAOFactory.getMessageDAOimplInstance().getMessageById(id);
            HttpSession session=req.getSession();
            session.setAttribute("message",message);
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("delMessage.jsp");
            requestDispatcher.forward(req,resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
