package com.example.FileUploadDownloadAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.FileUploadDownloadAPI.service.CSVService;

@Controller
@RequestMapping("/api/csv")
public class CSVController {
	 @Autowired
	  CSVService fileService;
	  
	  @GetMapping("/download")
	  public ResponseEntity<Resource> getFile() {
	    String filename = "tutorials.csv";
	    InputStreamResource file = new InputStreamResource(fileService.load());
        System.out.println();
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
	        .contentType(MediaType.parseMediaType("application/csv"))
	        .body(file);
	  }

}
//https://www.bezkoder.com/spring-boot-download-csv-file/
