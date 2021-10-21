package com.audi.ja.libraryAlex.service;

import com.audi.ja.libraryAlex.model.Book;
import com.audi.ja.libraryAlex.model.Member;
import com.audi.ja.libraryAlex.repository.LibraryRepository;

import java.util.HashMap;
import java.util.Random;

public class LibraryService {
    private LibraryRepository libraryRepository = new LibraryRepository();

    public void getBookFromDbByIsbn(int isbn){
        System.out.println(libraryRepository.getBookByIsbn(isbn).toString());
    }

    public void addNewMember(String name, String date){
        int randomID = generateRandomNumber();
        libraryRepository.insertMemberInDb(new Member(randomID, name, date));
    }

    public void addNewBook(String name, int ageRestriction){
        int randomID = generateRandomNumber();
        libraryRepository.insertBooksInDb(new Book(randomID,name,ageRestriction));
    }

    public void showAllBooks(){
        libraryRepository.getAllBooks();
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
