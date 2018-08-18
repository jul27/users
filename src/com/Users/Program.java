package com.Users;

import java.sql.*;

public class Program
{
    public static void main (String ... args)
    {
        try
        {

            Class.forName("org.sqlite.JDBC"); // имя движка бд
            Connection co = DriverManager.getConnection ("JDBC:sqlite:users.db");
            System.out.println("Connected");
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}