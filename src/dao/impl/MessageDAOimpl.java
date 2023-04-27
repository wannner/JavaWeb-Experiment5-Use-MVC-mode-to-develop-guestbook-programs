package dao.impl;

import dao.IMessageDAO;
import db.ConnectionManager;
import vo.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageDAOimpl implements IMessageDAO{

    @Override
    public List<Message> showAllMessage() {
        List<Message> list=new ArrayList<Message>();
        Message message=null;
        Connection connection= ConnectionManager.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str="SELECT * FROM MESSAGE";
        try {
            preparedStatement=connection.prepareStatement(str);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                message=new Message();
                message.setMessageID(resultSet.getInt(1));
                message.setTitle(resultSet.getString(2));
                message.setContent(resultSet.getString(3));
                message.setWriter(resultSet.getString(4));
                message.setWriterDate(dateFormat.format(resultSet.getTimestamp(5)));
                list.add(message);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionManager.closeConnection(connection);
            ConnectionManager.closeStatement(preparedStatement);
            ConnectionManager.closeResultSet(resultSet);
        }
        System.out.println(list.toString());
        return list;
    }

    @Override
    public void deleteMessage(int id) {
        Connection connection=ConnectionManager.getConnection();
        PreparedStatement preparedStatement=null;
        String str="DELETE FROM MESSAGE WHERE ID=?";
        try {
            preparedStatement=connection.prepareStatement(str);
            preparedStatement.setInt(1,id);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionManager.closeConnection(connection);
            ConnectionManager.closeStatement(preparedStatement);
        }
    }
}
