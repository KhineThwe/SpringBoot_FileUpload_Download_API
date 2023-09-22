package com.example.FileUploadDownloadAPI.upload;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {
    public static String saveFile(String fileName,MultipartFile multipartFile) throws IOException {
    	Path uploadDirectory = Paths.get("Files-Upload");
    	
    	String fileCode = RandomStringUtils.randomAlphabetic(8);
    	
    	try(InputStream inputStream = multipartFile.getInputStream()) {
    		Path filePath = uploadDirectory.resolve(fileCode + "-"+fileName);
    		Files.copy(inputStream, filePath,StandardCopyOption.REPLACE_EXISTING);
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new IOException("Error saving uploaded file "+ fileName,e);
		}
    	return fileCode;
    }
}
