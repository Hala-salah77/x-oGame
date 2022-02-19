package com.tictactoe.database;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DatabaseConnection {
    public Connection connection;
    public Statement statement;
    public PreparedStatement preparedStatement;
    public String query;
    public ResultSet resultSet; // used for store data from database    


    public DatabaseConnection(){
        startConnection();
    }
  
    private void startConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/game","root", "8101419");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void endConnection() {
        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
