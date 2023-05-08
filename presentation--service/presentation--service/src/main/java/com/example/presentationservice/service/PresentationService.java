package com.example.presentationservice.service;

import com.example.presentationservice.dto.response.SquareDto;
import com.example.presentationservice.entity.Presentation;
import com.example.presentationservice.repository.PresentationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PresentationService {
    private final PresentationRepository presentationRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;


    private static final Logger logger= LoggerFactory.getLogger(PresentationService.class);

    public PresentationService(PresentationRepository presentationRepository, KafkaTemplate<String, String> kafkaTemplate) {
        this.presentationRepository = presentationRepository;
        this.kafkaTemplate = kafkaTemplate;
    }
    public Double findById(long id){
       Optional<Presentation> presentation=presentationRepository.findById(id);
       if (presentation.isPresent()){
           this.kafkaTemplate.send("presentation-topic" , LocalDateTime.now()+"",presentation.get().getValue()+"");

           return presentation.get().getValue();

       }
       logger.error("id ye göre veri bulunamadı");
       return null;
    }




}
