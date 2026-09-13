package com.example.library.Controller;

import com.example.library.DTO.BorrowCreateDTO;
import com.example.library.Model.BorrowTicket;
import com.example.library.Service.BorrowTicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrows")
public class BorrowController {
    @Autowired
    private BorrowTicketService borrowTicketService;

    @PostMapping
    public ResponseEntity<?> borrowBook(@Valid @RequestBody BorrowCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PatchMapping("/borrows/{id}/return")
    public ResponseEntity<?> returnBook( @PathVariable Integer id) {
        BorrowTicket borrowTicket=borrowTicketService.returnBook(id);
        return ResponseEntity.status(HttpStatus.OK).body(borrowTicket);
    }
}
