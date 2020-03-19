package com.group1.library.product;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;



public interface StorageService {

    void savePicture(MultipartFile file);

    Resource loadAsResource(String filename);
}
