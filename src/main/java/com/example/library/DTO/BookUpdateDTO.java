package com.example.library.DTO;

import jakarta.validation.constraints.*;
public class BookUpdateDTO {

    @Min(0)
    private Integer stock;

    public BookUpdateDTO() {}
    public BookUpdateDTO(Integer stock) {this.stock = stock;}
    public Integer getStock() {return stock;}
    public void setStock(Integer stock) {this.stock = stock;}

}
