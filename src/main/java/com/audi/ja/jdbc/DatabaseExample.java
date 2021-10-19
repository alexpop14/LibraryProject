package com.audi.ja.jdbc;
import java.awt.print.Book;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseExample {

    public static void main(String[] args) {
        ArrayList<Bookk> books = new ArrayList<Bookk>();
        int id = 1;
        String sql = "SELECT * FROM books WHERE id = ?";

        try (Connection databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "pop8098");
             PreparedStatement statement = databaseConnection.prepareStatement(sql);
        ){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Successfully connected to database.");
            while(resultSet.next()){
                Bookk book = new Bookk(resultSet.getInt("id"), resultSet.getString("title"),
                        resultSet.getString("author"), resultSet.getInt("pages")
                );
                books.add(book);
            }

            System.out.println(books.toString());
            resultSet.close();
        } catch(SQLException exception){
            System.out.println("Error while connecting to database " + exception);
        }
    }

}
