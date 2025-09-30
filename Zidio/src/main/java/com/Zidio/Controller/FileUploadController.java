package com.Zidio.Controller;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.Zidio.Entity.User;
import com.Zidio.Repository.UserRepository;
import com.Zidio.Service.FileUploadService;

@RestController
@RequestMapping("/api/v1/uploadFiles")
public class FileUploadController {

    @Autowired
    private FileUploadService fileupload;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/resume")
    public ResponseEntity<String> uploadResume(
            @RequestParam("file") MultipartFile file,
            Principal principal) throws IOException {

        String email = principal.getName(); 

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

 
        String oldPublicId = null;
        if (user.getResumeUrl() != null && !user.getResumeUrl().isEmpty()) {
            oldPublicId = extractPublicId(user.getResumeUrl());
        }

        String resumeUrl = fileupload.uploadFile(file, "resume", oldPublicId);

        user.setResumeUrl(resumeUrl);
        userRepository.save(user);

        return ResponseEntity.ok(resumeUrl);
    }

    @PostMapping("/certificate")
    public ResponseEntity<String> uploadCertificate(@RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(fileupload.uploadFile(file, "Certificate", null));
    }

    @PostMapping("/invoice")
    public ResponseEntity<String> uploadInvoice(@RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(fileupload.uploadFile(file, "Invoice", null));
    }

    @GetMapping("/resume/{email}")
    public ResponseEntity<Map<String, String>> getResumeUrl(@PathVariable String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getResumeUrl() == null || user.getResumeUrl().isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Map<String, String> response = new HashMap<>();
        response.put("resumeUrl", user.getResumeUrl());
        return ResponseEntity.ok(response);
    }

    private String extractPublicId(String url) {
        try {
            String withoutExtension = url.substring(0, url.lastIndexOf('.'));
            return withoutExtension.substring(withoutExtension.lastIndexOf('/') + 1);
        } catch (Exception e) {
            return null;
        }
    }
    
    @GetMapping("/internal/count")
    public long getUploadedResumeCount() {
        return userRepository.countByResumeUrlIsNotNullAndResumeUrlNot("");
    }
}
