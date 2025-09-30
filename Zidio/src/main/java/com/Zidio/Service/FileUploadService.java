package com.Zidio.Service;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Zidio.Repository.UserRepository;
import com.Zidio.Security.CloudinaryConfig;
import com.cloudinary.utils.ObjectUtils;

@Service
public class FileUploadService {

    @Autowired
    private CloudinaryConfig cloudinaryConfig;
    
    @Autowired 
    private UserRepository userRepository;

    // Upload file, optionally delete old file
    public String uploadFile(MultipartFile file, String folder, String oldPublicId) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }

        String contentType = file.getContentType();
        String resourceType = "auto";

        if ("application/pdf".equalsIgnoreCase(contentType)) {
            resourceType = "raw"; // PDFs must be raw
        } else if (contentType != null && contentType.startsWith("image/")) {
            resourceType = "image";
        }

        // Delete old file if publicId provided
        if (oldPublicId != null && !oldPublicId.isEmpty()) {
            cloudinaryConfig.cloudinary().uploader()
                .destroy(oldPublicId, ObjectUtils.asMap("resource_type", resourceType));
        }

        // Upload new file
        Map<String, Object> uploadResult = cloudinaryConfig.cloudinary().uploader()
            .upload(file.getBytes(), ObjectUtils.asMap("folder", folder, "resource_type", resourceType));

        return (String) uploadResult.get("secure_url"); // URL to save in DB
    }
    
    public long countUploadedResumes() {
        return userRepository.countByResumeUrlIsNotNullAndResumeUrlNot("");
    }
}
