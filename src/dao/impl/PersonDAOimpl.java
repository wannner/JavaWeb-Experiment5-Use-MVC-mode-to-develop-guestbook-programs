package dao.impl;

import dao.IPersonDAO;
import db.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDAOimpl implements IPersonDAO {
    @Override
    public String loginCheck(String id, String password) {
        String name=null;
        Connection connection = ConnectionManager.getConnection();
        String str="SELECT NAME FROM person WHERE ID=? AND PASSWORD=?";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            preparedStatement = connection.prepareStatement(str);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                name=resultSet.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionManager.closeResultSet(resultSet);
            ConnectionManager.closeStatement(preparedStatement);
            ConnectionManager.closeConnection(connection);
        }
        return name;
    }
}
