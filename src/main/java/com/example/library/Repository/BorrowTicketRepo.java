package com.example.library.Repository;

import com.example.library.Model.BorrowTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowTicketRepo extends JpaRepository<BorrowTicket, Integer> {
}
