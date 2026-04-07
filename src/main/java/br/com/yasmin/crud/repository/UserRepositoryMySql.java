package br.com.yasmin.crud.repository;
import java.sql.*;
import java.util.Objects;

import io.github.cdimascio.dotenv.Dotenv;
public class UserRepositoryMySql {
    public static void main(String[] args)
    {
        try {
            Dotenv dotenv = Dotenv.load();
            String username = Objects.requireNonNull(dotenv.get("DB_USERNAME"), "DB_USERNAME is null");
            String password = Objects.requireNonNull(dotenv.get("DB_PASSWORD"), "DB_PASSWORD is null");
            String url = Objects.requireNonNull(dotenv.get("DB_URL"), "DB_URL is null");
            Connection myConn = DriverManager.getConnection(url, username, password);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

