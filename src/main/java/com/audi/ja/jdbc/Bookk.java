package com.audi.ja.jdbc;

public class Bookk {
    String title;
    int id;
    String author;
    int pages;

    Bookk(int id, String title, String author, int pages){
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "title='" + title + '\'' +
                ", id=" + id +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                '}';
    }
}
