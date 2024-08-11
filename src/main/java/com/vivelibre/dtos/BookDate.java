package com.vivelibre.dtos;

import java.sql.Timestamp;

public class BookDate {

    private Book book;

    private Timestamp date;

    public BookDate(Book book, String timeStamp) {
        this.book = book;
        long seconds = Long.parseLong(timeStamp);
        long milliseconds = seconds * 1000;
        this.date = new Timestamp(milliseconds);
    }

    @Override
    public String toString() {
        return "BookDate{" +
                "book=" + book +
                ", date=" + date +
                '}';
    }

}
