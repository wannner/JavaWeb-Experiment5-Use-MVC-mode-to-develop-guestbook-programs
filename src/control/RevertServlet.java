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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@WebServlet("/RevertServlet")
public class RevertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String statue=(String) req.getAttribute("statue");
        if(Objects.equals(null,statue)){//如果说为空代表从MessageServlet页面跳转来的
            statue=req.getParameter("statue");
        }
        if("showAllRevert".equals(statue)){
            int id = (int)req.getAttribute("id");
            List<Revert> list = DAOFactory.getRevertDAOimpInstance().findAllRevertByMessageId(id);
            HttpSession session=req.getSession();
            session.setAttribute("revertList",list);
            RequestDispatcher requestDispatcher= req.getRequestDispatcher("revertMessage.jsp");
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
            req.setAttribute("id",id);
            //获取当前的时间
            Date d = new Date();
            SimpleDateFormat sbf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = sbf.format(d);
            revert.setContent(content);
            revert.setWriter((String) session.getAttribute("name"));
            revert.setMessageID(id);
            revert.setWriterDate(currentTime);
            DAOFactory.getRevertDAOimpInstance().insertRevert(revert);
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("saveRevert.jsp");
            requestDispatcher.forward(req,resp);
        }else if("deleteRevert".equals(statue)){
            String revertId=req.getParameter("id");
            int id=0;
            for (int i = 0; i < revertId.length(); i++) {
                id=id*10+(revertId.charAt(i)-'0');
            }
            String messageId=req.getParameter("messageId");
            int id1=0;
            for (int i = 0; i < messageId.length(); i++) {
                id1=id1*10+(messageId.charAt(i)-'0');
            }
            DAOFactory.getRevertDAOimpInstance().deleteRevert(id);
            req.setAttribute("id",id1);
            RequestDispatcher requestDispatcher= req.getRequestDispatcher("delRevert.jsp");
            requestDispatcher.forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
