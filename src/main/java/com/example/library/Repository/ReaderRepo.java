package com.example.library.Repository;

import com.example.library.Model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReaderRepo extends JpaRepository<Reader, Integer> {
    List<Reader> findReaderByEmail(String email);
}
