package com.example.library.Controller;

import com.example.library.DTO.ReaderCreateDTO;
import com.example.library.Model.Reader;
import com.example.library.Repository.ReaderRepo;
import com.example.library.Service.ReaderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/readers")
public class ReaderController {
    @Autowired
    private ReaderService readerService;

    @PostMapping
    public ResponseEntity<?> createReader(@Valid @ModelAttribute ReaderCreateDTO dto) throws IOException {
        Reader reader=readerService.createReader(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(reader);

    }
}
