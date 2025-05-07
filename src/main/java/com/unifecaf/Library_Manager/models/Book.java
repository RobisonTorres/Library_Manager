package com.unifecaf.Library_Manager.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("BOOKS")
public class Book {

    @Id
    private Integer id;
    private String title;
    private String author;
    private String publisher;
    private byte[] cover;
    private String status;

    public Book() { }

    public Book(Integer id, String title, String author, String publisher, byte[] cover, String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.cover = cover;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}