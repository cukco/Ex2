package com.example.library.Service;

import com.example.library.DTO.BookCreateDTO;
import com.example.library.DTO.BookUpdateDTO;
import com.example.library.Exception.ResourceNotFoundException;
import com.example.library.Model.Book;
import com.example.library.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    private final String uploadDir="uploads/";

    public Book createBook(BookCreateDTO bookCreateDTO) throws IOException {
         String fileName="";

         if(bookCreateDTO.getCoverImage()!=null || !bookCreateDTO.getCoverImage().isEmpty()){

             Path uploadpath= Paths.get(uploadDir);
             if(!uploadpath.toFile().exists()){
                 Files.createDirectory(uploadpath);
             }

              fileName = UUID.randomUUID().toString() + "_" +
                     bookCreateDTO.getCoverImage().getOriginalFilename();

             Path filePath= uploadpath.resolve(fileName);

             Files.copy(bookCreateDTO.getCoverImage().getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
         }

         Book book=new Book();
         book.setTitle(bookCreateDTO.getTitle());
         book.setAuthor(bookCreateDTO.getAuthor());
         book.setStock(bookCreateDTO.getStock());
         book.setCoverUrl(fileName);

         return bookRepo.save(book);
    }

    public Book updatestock(BookUpdateDTO dto,Integer id){
        Book book=bookRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Book with id "+id+" not found"));
        book.setStock(dto.getStock());
        return bookRepo.save(book);
    }

}
