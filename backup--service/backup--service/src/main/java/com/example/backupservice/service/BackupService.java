package com.example.backupservice.service;

import com.example.backupservice.entity.Backup;
import com.example.backupservice.repository.BackupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BackupService {

    @Autowired
    BackupRepository backupRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final Logger logger= LoggerFactory.getLogger(BackupService.class);

    public BackupService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(
            topics = {"square-topic","cube-topic"},
            groupId = "group-id")
    public void consume(String message){
        Backup backup = new Backup();
        backup.setData(message);
        backupRepository.save(backup);

    }

}



