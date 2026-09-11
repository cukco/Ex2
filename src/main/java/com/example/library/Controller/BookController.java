package com.example.library.Controller;

import com.example.library.DTO.BookCreateDTO;
import com.example.library.DTO.BookUpdateDTO;
import com.example.library.Model.Book;
import com.example.library.Service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<?> uploadBook(@ModelAttribute BookCreateDTO dto) {
        try{
            Book book = bookService.createBook(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(book);
        }catch (IOException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateBook(@PathVariable int id,@Valid @RequestBody BookUpdateDTO dto) {
        Book book=bookService.updatestock(dto,id);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }



}
