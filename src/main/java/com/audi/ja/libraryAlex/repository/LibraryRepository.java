package com.audi.ja.libraryAlex.repository;

import com.audi.ja.libraryAlex.model.Book;
import com.audi.ja.libraryAlex.model.Member;

import java.sql.*;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;


public class LibraryRepository {

    public LibraryRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver class");
        }
    }

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

    public List<Book> getAllBooks(){

        String sql = "SELECT * FROM books";

        try (Connection databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryAlex", "root", "pop8098");
             PreparedStatement statement = databaseConnection.prepareStatement(sql);
        ){
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Successfully connected to database.");
            List<Book> booksOfMember = new LinkedList<>();
            while(resultSet.next()){
                Book book = new Book(resultSet.getInt("isbn"), resultSet.getString("bookName"),
                        resultSet.getInt("ageRestriction")
                );
                booksOfMember.add(book);
            }
            resultSet.close();
            return booksOfMember;
        } catch(SQLException exception){
            System.out.println("Error while connecting to database: " + exception);
        }
        return null;
    }

    public int checkIfValue(int isbn){
        int count = 0;
        String sql = "SELECT COUNT(*) as count from loan where isbn = ? AND actualReturn IS NULL;";

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

    public void returnBook(int bookIsbn, int memberID){

        String sql =  "UPDATE loan SET actualReturn = ? WHERE isbn = ? AND memberID = ?;";

        try (Connection databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryAlex", "root", "pop8098");
             PreparedStatement statement = databaseConnection.prepareStatement(sql);
        ){
            java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            statement.setDate(1, date);
            statement.setInt(2,bookIsbn);
            statement.setInt(3,memberID);
            statement.executeUpdate();
        } catch(SQLException exception){
            System.out.println("Error while connecting to database: " + exception);
        }
    }

    public List<Book> getBooksByMemberId(int memberId){

        String sql =  "SELECT books.isbn,bookName, ageRestriction from books inner join loan l on books.isbn = l.isbn where memberID = ? and actualReturn IS NULL;";

        try (Connection databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryAlex", "root", "pop8098");
             PreparedStatement statement = databaseConnection.prepareStatement(sql);
        ){
            statement.setInt(1,memberId);
            ResultSet resultSet = statement.executeQuery();

            List<Book> booksOfMember = new LinkedList<>();

            while(resultSet.next()){
                Book book = new Book(resultSet.getInt("isbn"), resultSet.getString("bookName"),
                        resultSet.getInt("ageRestriction")
                );
                booksOfMember.add(book);
            }
            resultSet.close();
            return booksOfMember;
        } catch(SQLException exception){
            System.out.println("Error while connecting to database: " + exception);
        }

        List<Book> books = new LinkedList<>();
        Book book = new Book(2145,"DSAGDGDSSGDSS",12);
        books.add(book);

        return books;
    }


    //--------------------------------------------MEMBERS------------------------------------------------------

    public List<Member> getAllMembers(){

        String sql = "SELECT * FROM members";

        try (Connection databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryAlex", "root", "pop8098");
             PreparedStatement statement = databaseConnection.prepareStatement(sql);
        ){
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Successfully connected to database.");
            List<Member> listOfMembers = new LinkedList<>();
            while(resultSet.next()){
                Member member = new Member(resultSet.getInt("memberID"), resultSet.getString("memberName"),
                        resultSet.getDate("bDay")
                );
                listOfMembers.add(member);
            }
            resultSet.close();
            return listOfMembers;
        } catch(SQLException exception){
            System.out.println("Error while connecting to database: " + exception);
        }
        return null;
    }


}
