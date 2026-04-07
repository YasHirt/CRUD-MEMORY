package br.com.yasmin.crud.repository;
import java.sql.*;
import io.github.cdimascio.dotenv.Dotenv;
public class UserRepositoryMySql {

    private final String url;
    private final String user;
    private final String password;
   public  UserRepositoryMySql(String url, String user, String password) {
       this.url = url;
       this.user = user;
       this.password = password;
   }
   private  Connection getConnection(){
       try {
           Connection myConn = DriverManager.getConnection(url, user, password);
           return myConn;
       } catch (SQLException e) {
           throw  new RuntimeException(e);
       }
   }
}

