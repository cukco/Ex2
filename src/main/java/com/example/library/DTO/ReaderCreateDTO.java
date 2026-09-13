package com.example.library.DTO;

import com.example.library.Validator.FileExtension;
import jakarta.validation.constraints.*;
import org.springframework.web.multipart.MultipartFile;

public class ReaderCreateDTO {
    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String fullName;

    @Pattern( regexp = "^0(3|5|7|8|9)[0-9]{8}$")
    private String  phoneNumber;

    @NotBlank
    private String  address;

    @FileExtension
    @NotNull
    private MultipartFile avatarFile;

    public ReaderCreateDTO(String email, String fullName, String phoneNumber, String address, MultipartFile avatarFile) {
        this.email = email;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.avatarFile = avatarFile;
        this.avatarFile = this.avatarFile;
    }

    public ReaderCreateDTO() {}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getFullName() {return fullName;}
    public void setFullName(String fullName) {this.fullName = fullName;}
    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}
    public MultipartFile getAvatarFile() {return avatarFile;}
    public void setAvatarFile(MultipartFile avatarFile) {this.avatarFile = avatarFile;}

}
