package com.example.library.Service;

import com.example.library.DTO.BookUpdateDTO;
import com.example.library.Exception.BookAlreadyReturnedException;
import com.example.library.Exception.ResourceNotFoundException;
import com.example.library.Model.Book;
import com.example.library.Model.BorrowTicket;
import com.example.library.Model.Status;
import com.example.library.Repository.BookRepo;
import com.example.library.Repository.BorrowTicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BorrowTicketService {
    @Autowired
    private BorrowTicketRepo borrowTicketRepo;

    @Autowired
    private BookRepo bookRepo;

    public BorrowTicket returnBook(Integer ticketId) {
        BorrowTicket borrowTicket = borrowTicketRepo.findById(ticketId).
                orElseThrow(()-> new ResourceNotFoundException("Ticket Not Found"));
        if(borrowTicket.getStatus().equals(Status.RETURNED)) throw new BookAlreadyReturnedException("Book Already Returned");
        borrowTicket.setStatus(Status.RETURNED);
        borrowTicket.setReturnDate(LocalDate.now());

        Book book=bookRepo.findById(Math.toIntExact(borrowTicket.getBookId()))
                . orElseThrow(()-> new ResourceNotFoundException("Book Not Found"));

        book.setStock(book.getStock()+1);
        bookRepo.save(book);
        return borrowTicketRepo.save(borrowTicket);
    }
}
