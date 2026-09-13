package com.example.library.Service;

import com.cloudinary.utils.ObjectUtils;
import com.example.library.CloudinaryConfig;
import com.example.library.DTO.ReaderCreateDTO;
import com.example.library.Model.Reader;
import com.example.library.Repository.ReaderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class ReaderService {
    @Autowired
    private CloudinaryConfig cloudinaryConfig;

    @Autowired
    private ReaderRepo readerRepo;

    public Reader createReader(ReaderCreateDTO readerCreateDTO) throws IOException {
       if(readerRepo.findReaderByEmail(readerCreateDTO.getEmail())==null){
           throw new RuntimeException("Email already exists");
       }
       Map uploadResult=cloudinaryConfig.cloudinary().uploader().
               upload(readerCreateDTO.getAvatarFile().getBytes(), ObjectUtils.emptyMap());

       String url=uploadResult.get("url").toString();

       Reader reader=new Reader();
       reader.setEmail(readerCreateDTO.getEmail());
       reader.setFullName(readerCreateDTO.getFullName());
       reader.setPhoneNumber(readerCreateDTO.getPhoneNumber());
       reader.setAddress(readerCreateDTO.getAddress());
       reader.setAvatar(url);

       return readerRepo.save(reader);
    }
}
