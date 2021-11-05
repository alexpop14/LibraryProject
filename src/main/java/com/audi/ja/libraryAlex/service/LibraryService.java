package com.audi.ja.libraryAlex.service;

import com.audi.ja.libraryAlex.model.Book;
import com.audi.ja.libraryAlex.model.Member;
import com.audi.ja.libraryAlex.repository.LibraryRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class LibraryService {
    private LibraryRepository libraryRepository = new LibraryRepository();

    public Book getBookFromDbByIsbn(int isbn){
        return libraryRepository.getBookByIsbn(isbn);
    }

    public void addNewMember(String name, String date){
        int randomID = generateRandomNumber();
        libraryRepository.insertMemberInDb(new Member(randomID, name, date));
    }

    public void addNewBook(String name, int ageRestriction){
        int randomID = generateRandomNumber();
        libraryRepository.insertBooksInDb(new Book(randomID,name,ageRestriction));
    }

    public List<Book> showAllBooks(){
        return libraryRepository.getAllBooks();
    }



    public int generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(100000000);
    }

    public void borrowBook(int bookID, int memberID) {
        if (!checkIfBookIsBorrowed(bookID)){
            libraryRepository.addLoan(bookID,memberID);
        } else {
            System.out.println("Please check");
        }
    }

    public boolean checkIfBookIsBorrowed(int isbn){
        int result = libraryRepository.checkIfValue(isbn);
        return result > 0;
    }


    public void returnBook(int bookID, int memberID){
        libraryRepository.returnBook(bookID, memberID);
    }

    public List<Book> showMyBooks(int memberId){
        return libraryRepository.getBooksByMemberId(memberId);
    }

    //--------------------------------------------MEMBERS------------------------------------------------------

    public List<Member> showAllMembers(){
        return libraryRepository.getAllMembers();
    }
}
