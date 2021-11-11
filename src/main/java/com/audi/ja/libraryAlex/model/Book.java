package com.audi.ja.libraryAlex.model;

public class Book {
    private String name;
    private int isbn;
    private boolean lendOut;
    private int ageRestriction;
    private int memberID;

    public Book(int iban, String name, int ageRestriction, boolean lendOut){
        this.name = name;
        this.isbn = iban;
        this.ageRestriction = ageRestriction;
        this.lendOut = lendOut;
    }

    public String getBookName(){
        return this.name;
    }

    public int getIsbn(){return this.isbn;}

    public int getAgeRestriction(){
        return this.ageRestriction;
    }

    public boolean getLendOut(){
        return this.lendOut;
    }

    public void setMembersID(int memberID){
        this.memberID = memberID;
    }

    public void setLendOut(boolean LendOut){
        this.lendOut = LendOut;
    }


    @Override
    public String toString() {
        return "name = " + name + "\n" +
                "isbn = " + isbn + "\n" +
                "ageRestriction = " + ageRestriction + "\n";
    }
}

