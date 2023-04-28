package dao.impl;

import dao.IRevertDAO;
import db.ConnectionManager;
import vo.Revert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RevertDAOimpl implements IRevertDAO {
    @Override
    public void insertRevert(Revert revert) {
        Connection connection= ConnectionManager.getConnection();
        PreparedStatement preparedStatement=null;
        System.out.println(revert.getContent());
        String str="INSERT INTO REVERT(MESSAGEID,CONTENT,WRITER,WRITERDATE) VALUE(?,?,?,?)";
        try {
            preparedStatement= connection.prepareStatement(str);
            preparedStatement.setInt(1,revert.getMessageID());
            preparedStatement.setString(2,revert.getContent());
            preparedStatement.setString(3,revert.getWriter());
            preparedStatement.setString(4,revert.getWriterDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionManager.closeConnection(connection);
            ConnectionManager.closeStatement(preparedStatement);
        }
    }
}
