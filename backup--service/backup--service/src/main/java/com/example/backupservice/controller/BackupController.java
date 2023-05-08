package com.example.backupservice.controller;

import com.example.backupservice.entity.Backup;
import com.example.backupservice.service.BackupService;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class BackupController {
    private final BackupService backupService;
    private final KafkaTemplate<String, Backup> kafkaTemplate;
    public BackupController(BackupService backupService, KafkaTemplate<String, Backup> kafkaTemplate) {
        this.backupService = backupService;

        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/")
    public ResponseEntity<String> sendMessage(@RequestBody Backup backup) {
        kafkaTemplate.send("transfer-backup", UUID.randomUUID().toString(), backup);
        return ResponseEntity.ok("Message sent to kafka topic");

    }

}
