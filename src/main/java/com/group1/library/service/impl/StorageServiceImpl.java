package com.group1.library.service.impl;

import com.group1.library.service.inter.StorageService;
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

/**
 * <code>Class StorageServiceImpl</code> defines...
 */
@Service
public class StorageServiceImpl implements StorageService {

    // ATTRIBUTE
    private final Path rootlocation;

    /**
     * Constructs a new storageServiceImpl with {@code rootlocation} as its detail.
     */
    public StorageServiceImpl() {
        this.rootlocation = Paths.get("uploads");
    }

    /**
     * Method to save a picture associate to a product.
     * stock a file into a RootLocation.
     *
     * @param file the file to save into the RootLocation.
     * @throws RuntimeException if the file failed to go into RootLocation.
     */
    @Override
    public void savePicture(MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try (InputStream inputStream = file.getInputStream()) {
            Path target = this.rootlocation.resolve(filename);
            if (!target.toFile().exists()) {
                Files.createDirectories(target);
            }
            Files.copy(inputStream, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file" + filename, e);
        }
    }

    /**
     * Method to load a file.
     * find the file with the path and then load it.
     * check if the file exist and readable.
     *
     * @param filename the name of the file to find with the path.
     * @return An instance of Resource.
     * @throws RuntimeException if the file failed to get stored.
     */
    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path filePath = this.rootlocation.resolve(filename);
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Failed to get stored file " + filename);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failed to get stored file " + filename);
        }
    }
}
