package jsp.project.dao;


import jsp.project.dao.UserDAO;
import jsp.project.model.User;
//package net.javaguides.login.database;
import jsp.project.controller.UserServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jsp.project.model.LoginBean;

//import net.javaguides.login.bean.LoginBean;

public class LoginDao {    
    private String jdbcURL = "jdbc:mysql://localhost:3306";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345";
    private static final String SELECT_USER_BY_PASS = 
            "select * from register.admin where username = ? and password = ? ";
      private static final String INSERT_USERS_SQL  = 
            "INSERT INTO register.admin" + "  (username, password) VALUES " +
        " (?, ?);";
    
    public LoginDao() {}
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public boolean validate(LoginBean loginBean) throws SQLException {
        //System.out.println(INSERT_USERS_SQL);
        boolean status = false;
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = 
               connection.prepareStatement(SELECT_USER_BY_PASS)) {
            //PreparedStatement preparedStatement = connection.prepareStatement("select * from login where username = ? and password = ? ")) {
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());
            //System.out.println("Hello World");
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
            //System.out.println("Hello World");
            //System.out.print(status);
        }
        
        return status;
    }
    
    
    public void insertUser(LoginBean loginBean) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = 
                    connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());
            //preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //printSQLException(e);
        }
    }
    
    
    
    
}
    
   