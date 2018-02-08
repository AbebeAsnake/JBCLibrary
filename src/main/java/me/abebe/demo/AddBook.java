package me.abebe.demo;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class AddBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String bookTitle;
    @NotNull
    private  String author;
    @NotNull
    private long yearOfPublication;

    private String ISBN;
    private String bookImage;

    private String state;

    public long getId() {
        return id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public long getYearOfPublication() {
        return yearOfPublication;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getBookImage() {
        return bookImage;
    }

    public String getState() {
        return state;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearOfPublication(long yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public void setState(String state) {
        this.state = state;
    }
}
