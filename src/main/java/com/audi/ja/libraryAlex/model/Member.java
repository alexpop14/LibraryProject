package com.audi.ja.libraryAlex.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Member {
    private String name;
    private int memberID;
    private int booksLendOut;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
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

    public Member(int memberID, String name, Date bDay) {
        this.name = name;
        this.memberID = memberID;
        this.bDay = bDay;
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
