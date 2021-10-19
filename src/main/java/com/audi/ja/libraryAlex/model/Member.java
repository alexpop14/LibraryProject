package com.audi.ja.libraryAlex.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Member {
    private String name;
    private int memberID;
    private int booksLendOut;
    private java.util.Date date;
    private ArrayList<Book> booksOfMember = new ArrayList<Book>();

    public Member(int memberID, String name, String date) {
        this.name = name;
        SimpleDateFormat stringToDate = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.date = stringToDate.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.memberID = memberID;
    }

    public Date getDate() {
        return this.date;
    }

    public String getNameOfMember(){
        return this.name;
    }

    public int getMemberID(){
        return this.memberID;
    }

    public void deleteBookOfMember(Book book){
        this.booksOfMember.remove(book);
    }

    public ArrayList<Book> getArrayListOfBooks(){
        return this.booksOfMember;
    }

    public void addBookToBooksList(Book book){
        this.booksOfMember.add(book);
    }



}
