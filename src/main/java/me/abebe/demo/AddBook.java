package me.abebe.demo;

import javax.persistence.Entity;

@Entity
public class AddBook {
    private long id;
    private String bookTitle;
    private  String author;
    private long yearOfPublication;
    private String ISBNNumber;
    private String bookImage;
    private String state;
}
