package control;

import factory.DAOFactory;
import vo.Message;
import vo.Revert;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
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
        } else if ("showMessage".equals(statue)){//显示某个具体的信息时，他的留言要一起显示
            int id=0;
            String messageId=req.getParameter("id");
            for (int i = 0; i < messageId.length(); i++) {
                id=id*10+(messageId.charAt(i)-'0');
            }
            Message message = DAOFactory.getMessageDAOimplInstance().getMessageById(id);
            HttpSession session=req.getSession();
            session.setAttribute("message",message);
            req.setAttribute("id",id);
            req.setAttribute("statue","showAllRevert");
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("RevertServlet");//跳转到RevertServlet去获取留言
            requestDispatcher.forward(req,resp);
        }else if("insertRevert".equals(statue)){
            HttpSession session=req.getSession();
            Revert revert=new Revert();
            String content = req.getParameter("content");
            String messageId=req.getParameter("id");
            int id=0;
            for (int i = 0; i < messageId.length(); i++) {
                id=id*10+(messageId.charAt(i)-'0');
            }
            //获取当前的时间
            Date d = new Date();
            SimpleDateFormat sbf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = sbf.format(d);
            revert.setContent(content);
            revert.setWriter((String) session.getAttribute("name"));
            revert.setMessageID(id);
            revert.setWriterDate(currentTime);
            DAOFactory.getRevertDAOimpInstance().insertRevert(revert);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
