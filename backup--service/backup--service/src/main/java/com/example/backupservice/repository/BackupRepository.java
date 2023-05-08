package com.example.backupservice.repository;

import com.example.backupservice.entity.Backup;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackupRepository extends MongoRepository<Backup,String> {
}
