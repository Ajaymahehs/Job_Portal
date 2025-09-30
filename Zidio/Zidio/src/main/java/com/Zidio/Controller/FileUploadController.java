package com.Zidio.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Zidio.Service.FileUploadService;

@RestController
@RequestMapping("/api/v1/uploadFiles")
public class FileUploadController {

	@Autowired
	private FileUploadService fileupload;
	
	@PostMapping("/resume")
	public ResponseEntity<String>uploadResume(@RequestParam("file") MultipartFile file) throws IOException{
		return ResponseEntity.ok(fileupload.uploadFile(file,  "resume"));
	}
	
	@PostMapping("/image")
	public ResponseEntity<String>uploadCertificate(@RequestParam("file") MultipartFile file) throws IOException{
		return ResponseEntity.ok(fileupload.uploadFile(file, "Certificate"));
	}
	
	@PostMapping("/invoice")
	public ResponseEntity<String>invoice(@RequestParam("file") MultipartFile file) throws IOException{
		return ResponseEntity.ok(fileupload.uploadFile(file, "Invoice"));
	}
}
