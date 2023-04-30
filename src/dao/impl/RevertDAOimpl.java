package dao.impl;

import dao.IRevertDAO;
import db.ConnectionManager;
import vo.Revert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RevertDAOimpl implements IRevertDAO {
    @Override
    public void insertRevert(Revert revert) {
        Connection connection= ConnectionManager.getConnection();
        PreparedStatement preparedStatement=null;
        System.out.println(revert.getContent());
        String str="INSERT INTO REVERT(MESSAGEID,CONTENT,WRITER,WRITEDATE) VALUE(?,?,?,?)";
        try {
            preparedStatement= connection.prepareStatement(str);
            preparedStatement.setInt(1,revert.getMessageID());
            preparedStatement.setString(2,revert.getContent());
            preparedStatement.setString(3,revert.getWriter());
            preparedStatement.setString(4,revert.getWriterDate());
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionManager.closeConnection(connection);
            ConnectionManager.closeStatement(preparedStatement);
        }
    }

    @Override
    public List<Revert> findAllRevertByMessageId(int id) {
        Connection connection=ConnectionManager.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String str="SELECT * FROM REVERT WHERE MESSAGEID=?";
        List<Revert> list=new ArrayList<>();
        try {
            preparedStatement= connection.prepareStatement(str);
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Revert revert=new Revert();
                revert.setRevertID(resultSet.getInt(1));
                revert.setMessageID(resultSet.getInt(2));
                revert.setContent(resultSet.getString(3));
                revert.setWriter(resultSet.getString(4));
                revert.setWriterDate(resultSet.getString(5));
                list.add(revert);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionManager.closeConnection(connection);
            ConnectionManager.closeStatement(preparedStatement);
            ConnectionManager.closeResultSet(resultSet);
        }
        return list;
    }

}
