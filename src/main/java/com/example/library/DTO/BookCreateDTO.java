package com.example.library.DTO;

import org.springframework.web.multipart.MultipartFile;

public class BookCreateDTO {
    private String title;
    private String author;
    private Integer stock;
    private MultipartFile coverImage;

    public BookCreateDTO() {}

    public BookCreateDTO(String title, String author, Integer stock, MultipartFile coverImage) {
        this.title = title;
        this.author = author;
        this.stock = stock;
        this.coverImage = coverImage;
    }

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}
    public Integer getStock() {return stock;}
    public void setStock(Integer stock) {this.stock = stock;}
    public MultipartFile getCoverImage() {return coverImage;}
    public void setCoverImage(MultipartFile coverImage) {this.coverImage = coverImage;}

}
