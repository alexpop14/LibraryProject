package com.audi.ja.libraryAlex.service;

import com.audi.ja.libraryAlex.model.Book;
import com.audi.ja.libraryAlex.model.Member;
import com.audi.ja.libraryAlex.repository.LibraryRepository;

import java.util.HashMap;
import java.util.Random;

public class LibraryService {
    private HashMap<Integer, Book> booksMap = new HashMap();
    private HashMap<Integer, Member> membersMap = new HashMap();
    private LibraryRepository libraryRepository = new LibraryRepository();

    public void getBookFromDbByIsbn(int isbn){
        libraryRepository.getBookByIsbn(isbn);
    }

    public void addNewMember(String name, String date){
        int randomID = generateRandomNumber();
        membersMap.put(randomID, new Member(randomID, name, date));
        libraryRepository.insertMemberInDb(new Member(randomID, name, date));
    }

    public void addNewBook(String name, int ageRestriction){
        int randomID = generateRandomNumber();
        booksMap.put(randomID, new Book(randomID,name,ageRestriction));
        libraryRepository.insertBooksInDb(new Book(randomID,name,ageRestriction));
    }

    public void getAllBooks(){
        libraryRepository.getAllBooks();
    }

    public Member getMember(String name){
        for (Member member : membersMap.values()) {
            if (member.getNameOfMember().equals(name)) {
                return member;
            }
        }
        return null;
    }


    public int generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(100000000);
    }

    public Book getBooksName(String name){
        for (Book book : booksMap.values()) {
            if (book.getBookName().equals(name)) {
                return book;
            }
        }
        return null;
    }

    public int getBooksIban(String name){
        for (Book book : booksMap.values()) {
            if (book.getBookName().equals(name)) {
                return book.getIsbn();
            }
        }
        return 0;
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


    public void returnBook(int bookID){
        /*
        for (com.audi.ja.libraryAlex.model.Member member : membersMap.values()) {
            if (member.getMemberID() == (booksMap.get(bookID)).getIsbn()){
                booksMap.get(bookID).setLendOut(true);
                membersMap.get(memberID).deleteBookOfMember(booksMap.get(memberID));
            }
        }*/

        libraryRepository.returnBook(bookID);
    }

    public void showMyBooks(int memberId){
        libraryRepository.showMyBooks(memberId);
    }
}
