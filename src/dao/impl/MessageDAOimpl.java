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
        return list;
    }

    @Override
    public void deleteMessage(int id) {
        Connection connection=ConnectionManager.getConnection();
        PreparedStatement preparedStatement=null,preparedStatement1=null;
        String str="DELETE FROM MESSAGE WHERE messageID=?";
        try {
            preparedStatement=connection.prepareStatement(str);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            preparedStatement1 = connection.prepareStatement("SET @row_num = 0");
            preparedStatement1.executeUpdate();
            preparedStatement1 = connection.prepareStatement("UPDATE message SET messageID = (@row_num := @row_num + 1) ORDER BY messageID");
            preparedStatement1.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionManager.closeConnection(connection);
            ConnectionManager.closeStatement(preparedStatement);
            ConnectionManager.closeStatement(preparedStatement1);
        }
    }

    @Override
    public Message getMessageById(int id) {
        Connection connection=ConnectionManager.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String str="SELECT * FROM MESSAGE WHERE MESSAGEID=?";
        Message message=new Message();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            preparedStatement=connection.prepareStatement(str);
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                message=new Message();
                message.setMessageID(resultSet.getInt(1));
                message.setTitle(resultSet.getString(2));
                message.setContent(resultSet.getString(3));
                message.setWriter(resultSet.getString(4));
                message.setWriterDate(dateFormat.format(resultSet.getTimestamp(5)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionManager.closeStatement(preparedStatement);
            ConnectionManager.closeConnection(connection);
            ConnectionManager.closeResultSet(resultSet);
        }
        return message;
    }

    @Override
    public void insertNewMessage(Message message) {
        Connection connection=ConnectionManager.getConnection();
        PreparedStatement preparedStatement=null,preparedStatement1=null;
        String str="INSERT INTO MESSAGE(TITLE,CONTENT,WRITER,WRITEDATE) VALUE(?,?,?,?)";
        try {
            preparedStatement= connection.prepareStatement(str);
            preparedStatement.setString(1, message.getTitle());
            preparedStatement.setString(2, message.getContent());
            preparedStatement.setString(3, message.getWriter());
            preparedStatement.setString(4, message.getWriterDate());
            preparedStatement.executeUpdate();
            preparedStatement1 = connection.prepareStatement("SET @row_num = 0");
            preparedStatement1.executeUpdate();
            preparedStatement1 = connection.prepareStatement("UPDATE message SET messageID = (@row_num := @row_num + 1) ORDER BY messageID");
            preparedStatement1.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionManager.closeStatement(preparedStatement);
            ConnectionManager.closeConnection(connection);
        }
    }
}
