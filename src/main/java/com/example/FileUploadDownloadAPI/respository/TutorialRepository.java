package com.example.FileUploadDownloadAPI.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FileUploadDownloadAPI.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

}
