package com.example.library.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "borrow_tickets")
public class BorrowTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String username;

    @Column
    private Long bookId;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    private LocalDate returnDate;


    public BorrowTicket() {}

    public BorrowTicket(String username, Long bookId, Status status, LocalDate returnDate) {
        this.username = username;
        this.bookId = bookId;
        this.status = status;
        this.returnDate = returnDate;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public Long getBookId() {return bookId;}
    public void setBookId(Long bookId) {this.bookId = bookId;}
    public Status getStatus() {return status;}
    public void setStatus(Status status) {this.status = status;}
    public LocalDate getReturnDate() {return returnDate;}
    public void setReturnDate(LocalDate returnDate) {this.returnDate = returnDate;}

}
