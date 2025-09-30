package com.Zidio.Service;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Zidio.Security.CloudinaryConfig;
import com.cloudinary.utils.ObjectUtils;

@Service
public class FileUploadService {
	
	@Autowired
	private CloudinaryConfig cloudinaryConfig;
	
	public String uploadFile(MultipartFile file, String folder) throws IOException{
	try{
		Map uploadFile= cloudinaryConfig.cloudinary().uploader().upload(file.getBytes(),ObjectUtils.asMap("folder",folder));
		return (String)uploadFile.get("secure_url");
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	return null;
	}
}
