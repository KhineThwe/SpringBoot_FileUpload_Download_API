package com.example.FileUploadDownloadAPI.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FileUploadDownloadAPI.helper.CSVHelper;
import com.example.FileUploadDownloadAPI.model.Tutorial;
import com.example.FileUploadDownloadAPI.respository.TutorialRepository;

@Service
public class CSVService {
	@Autowired
	TutorialRepository repository;

	public ByteArrayInputStream load() {
		List<Tutorial> tutorials = repository.findAll();

		ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tutorials);
		return in;
	}

}
