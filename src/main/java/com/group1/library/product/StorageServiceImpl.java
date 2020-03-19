package com.group1.library.product;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class StorageServiceImpl implements StorageService {

    //Attributes
    private final Path ROOTLOCATION;

    //Constructor
    public StorageServiceImpl() {
        this.ROOTLOCATION = Paths.get("uploads");
    }


    /**
     * Method to save a picture
     * stock a file into a RootLocation
     * @param file the file to save into the RootLocation
     * @return void
     * @throws RuntimeException if the file failed to go into RootLocation
     */
    @Override
    public void savePicture(MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try (InputStream inputStream = file.getInputStream()){
            Path target = this.ROOTLOCATION.resolve(filename);
            if(!target.toFile().exists()){
                Files.createDirectories(target);
            }

            Files.copy(inputStream,target, StandardCopyOption.REPLACE_EXISTING);


        } catch (IOException e) {
            throw new RuntimeException("Failed to store File"+ filename, e);
        }

    }

    /**
     * Method to load a file
     * find the file with the path and then load it
     * check if the file exist and readable
     * @param filename the file to find to the path
     * @return Resource
     * @throws RuntimeException if the file failed to get stored
     */
    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path filePath = this.ROOTLOCATION.resolve(filename);
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists() || resource.isReadable()){
                return resource;
            } else{
                throw new RuntimeException("Failed to get stored file "+filename);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failed to get stored file "+filename);
        }
    }
}
