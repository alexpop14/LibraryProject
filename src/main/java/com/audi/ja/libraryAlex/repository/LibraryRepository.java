package com.audi.ja.libraryAlex.repository;

import com.audi.ja.libraryAlex.model.Book;
import com.audi.ja.libraryAlex.model.Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class LibraryRepository {
    public static void main(String[] args) {

    }

    public void insertBooksInDb(Book book){

        String sql =  "INSERT INTO books VALUES (?,?,?);";

        try (Connection databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryAlex", "root", "pop8098");
             PreparedStatement statement = databaseConnection.prepareStatement(sql);
        ){
            statement.setInt(1,book.getIsbn());
            statement.setString(2,book.getBookName());
            statement.setInt(3,book.getAgeRestriction());
            statement.executeUpdate();
            System.out.println("Successfully added book to database.");
        } catch(SQLException exception){
            System.out.println("Error while connecting to database: " + exception);
        }
    }

    public void insertMemberInDb(Member member){

        String sql =  "INSERT INTO members VALUES (?,?,?);";

        try (Connection databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryAlex", "root", "pop8098");
             PreparedStatement statement = databaseConnection.prepareStatement(sql);
        ){
            java.sql.Date sqlDate = new java.sql.Date(member.getbDay().getTime());
            statement.setInt(1,member.getMemberID());
            statement.setString(2,member.getNameOfMember());
            statement.setDate(3,sqlDate);
            statement.executeUpdate();
            System.out.println("Successfully added book to database.");
        } catch(SQLException exception){
            System.out.println("Error while connecting to database: " + exception);
        }
    }

    public Book getBookByIsbn(int isbn){

        String sql = "SELECT * FROM books WHERE isbn = ?";


        try (Connection databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryAlex", "root", "pop8098");
             PreparedStatement statement = databaseConnection.prepareStatement(sql);
        ){
            statement.setInt(1,isbn);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Successfully connected to database.");

            while(resultSet.next()){
                Book book = new Book(resultSet.getInt("isbn"),resultSet.getString("bookName"),
                        resultSet.getInt("ageRestriction"));
                return book;
            }
            resultSet.close();
        } catch(SQLException exception){
            System.out.println("Error while connecting to database: " + exception);
        }
        return null;
    }

    public Book getAllBooks(){

        String sql = "SELECT * FROM books";

        try (Connection databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryAlex", "root", "pop8098");
             PreparedStatement statement = databaseConnection.prepareStatement(sql);
        ){
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Successfully connected to database.");

            while(resultSet.next()){
                Book book = new Book(resultSet.getInt("isbn"), resultSet.getString("bookName"),
                        resultSet.getInt("ageRestriction")
                );
                return book;
            }
            resultSet.close();
        } catch(SQLException exception){
            System.out.println("Error while connecting to database: " + exception);
        }
        return null;
    }

    public int checkIfValue(int isbn){
        int count = 0;
        String sql = "SELECT COUNT(*) as count from loan where isbn = ?;";

        try (Connection databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryAlex", "root", "pop8098");
             PreparedStatement statement = databaseConnection.prepareStatement(sql);
        ){
            statement.setInt(1,isbn);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                count = resultSet.getInt("count");
            }
            System.out.println("Successfully connected to database.");
            resultSet.close();
        } catch(SQLException exception){
            System.out.println("Error while connecting to database: " + exception);
        }
        return count;

    }


    public void addLoan(int bookIsbn, int memberID){

        String sql =  "INSERT INTO loan (isbn, memberID, startOfLoan, endOfLoan) VALUES (?,?,CURRENT_DATE,(SELECT DATE_ADD(CURRENT_DATE, INTERVAL 30 DAY)));";

        try (Connection databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryAlex", "root", "pop8098");
             PreparedStatement statement = databaseConnection.prepareStatement(sql);
        ){
            statement.setInt(1,bookIsbn);
            statement.setInt(2,memberID);
            statement.executeUpdate();
            System.out.println("You successfully borrowed this book.");
        } catch(SQLException exception){
            System.out.println("Error while connecting to database: " + exception);
        }

    }

    public void returnBook(int bookIsbn){

        String sql =  "delete from loan where isbn = ?;";

        try (Connection databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryAlex", "root", "pop8098");
             PreparedStatement statement = databaseConnection.prepareStatement(sql);
        ){
            statement.setInt(1,bookIsbn);
            statement.executeUpdate();
            System.out.println("com.audi.ja.libraryAlex.model.Book successfully returned.");
        } catch(SQLException exception){
            System.out.println("Error while connecting to database: " + exception);
        }
    }

    public void showMyBooks(int memberId){

        String sql =  "SELECT books.isbn,bookName, ageRestriction from books inner join loan l on books.isbn = l.isbn where memberID = ?;";

        try (Connection databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryAlex", "root", "pop8098");
             PreparedStatement statement = databaseConnection.prepareStatement(sql);
        ){
            statement.setInt(1,memberId);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Book book = new Book(resultSet.getInt("isbn"), resultSet.getString("bookName"),
                        resultSet.getInt("ageRestriction")
                );
                System.out.println(book);
            }
            System.out.println("com.audi.ja.libraryAlex.model.Book successfully returned.");
        } catch(SQLException exception){
            System.out.println("Error while connecting to database: " + exception);
        }
    }



}
