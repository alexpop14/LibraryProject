package com.audi.ja.libraryAlex.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Member {
    private String name;
    private int memberID;
    private int booksLendOut;
    private java.util.Date bDay;

    public Member(int memberID, String name, String date) {
        this.name = name;
        SimpleDateFormat stringToDate = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.bDay = stringToDate.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.memberID = memberID;
    }

    public Date getbDay() {
        return this.bDay;
    }

    public String getNameOfMember(){
        return this.name;
    }

    public int getMemberID(){
        return this.memberID;
    }

}
