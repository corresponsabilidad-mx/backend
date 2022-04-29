package mx.org.corresponsabilidadsocial.api.blog.services;

import com.google.cloud.storage.StorageOptions;
import mx.org.corresponsabilidadsocial.api.blog.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {

    @Autowired
    FileRepository fileRepository;

    public String upload(MultipartFile multipartFile) {

        try {
            String fileName = multipartFile.getOriginalFilename();         
            fileName = UUID.randomUUID().toString().concat(fileRepository.getExtension(fileName));

            File file = fileRepository.convertToFile(multipartFile, fileName);
            String TEMP_URL = fileRepository.uploadFile(file, fileName);
            file.delete();
            return "Successfully Uploaded !" + TEMP_URL;
        } catch (Exception e) {
            e.printStackTrace();
            return "Unsuccessfully Uploaded!" + e;
        }
    }

}
