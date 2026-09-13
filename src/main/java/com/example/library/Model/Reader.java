package com.example.library.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "readers")
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String email;

    @Column
    private String fullName;

    @Column
    private String phoneNumber;

    @Column
    private String address;

    @Column
    private String avatar;

    public Reader() {}

    public Reader(String email, String fullName, String phoneNumber, String address, String avatar) {
        this.email = email;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.avatar = avatar;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getFullName() {return fullName;}
    public void setFullName(String fullName) {this.fullName = fullName;}
    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}
    public String getAvatar() {return avatar;}
    public void setAvatar(String avatar) {this.avatar = avatar;}



}
