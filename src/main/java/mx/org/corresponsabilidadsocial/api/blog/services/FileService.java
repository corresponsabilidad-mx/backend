package mx.org.corresponsabilidadsocial.api.blog.services;

import mx.org.corresponsabilidadsocial.api.blog.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
public class FileService {

    @Autowired
    FileRepository fileRepository;

    public String upload(MultipartFile multipartFile) {

        try {
            String fileName = multipartFile.getOriginalFilename();                        // to get original file name
            fileName = UUID.randomUUID().toString().concat(fileRepository.getExtension(fileName));  // to generated random string values for file name.

            File file = fileRepository.convertToFile(multipartFile, fileName);                      // to convert multipartFile to File
            String TEMP_URL = fileRepository.uploadFile(file, fileName);                                   // to get uploaded file link
            file.delete();                                                                // to delete the copy of uploaded file stored in the project folder
            return "Successfully Uploaded !" + TEMP_URL;                     // Your customized response
        } catch (Exception e) {
            e.printStackTrace();
            return "Unsuccessfully Uploaded!" + e;
        }

    }
}
