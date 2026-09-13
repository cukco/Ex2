package com.example.library.DTO;

import com.example.library.Validator.ExistingBookId;
import jakarta.validation.constraints.NotBlank;

public class BorrowCreateDTO {
    @NotBlank
    private String username;

    @ExistingBookId
    private Long bookId;

    public BorrowCreateDTO() {}

    public BorrowCreateDTO(String username, Long bookId) {
        this.username = username;
        this.bookId = bookId;
    }

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public Long getBookId() {return bookId;}
    public void setBookId(Long bookId) {this.bookId = bookId;}

}
