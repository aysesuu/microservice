package com.example.squareservice.service;

import com.example.squareservice.dto.SquareDto;
import com.example.squareservice.entity.Square;
import com.example.squareservice.repository.SquareRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;



@Service
public class SquareService {
    @Autowired
    private ModelMapper modelMapper;
    final private SquareRepository squareRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final Logger logger= LoggerFactory.getLogger(SquareService.class);
    SquareService(SquareRepository squareRepository, KafkaTemplate<String, String> kafkaTemplate) {
        this.squareRepository = squareRepository;
        this.kafkaTemplate = kafkaTemplate;
    }


    public SquareDto save (SquareDto squareDto){
        try {
            Square square=modelMapper.map(squareDto,Square.class);
            square.setValue(square.getNumberOne() * square.getNumberTwo());
            this.kafkaTemplate.send("square-topic" , LocalDateTime.now()+"",square.getNumberOne()+" ,"+square.getNumberTwo());

            return modelMapper.map(squareRepository.save(square),SquareDto.class);
    }
        catch (Exception exception) {
            logger.error(exception.getMessage());
        }
       return null;
    }
    public List<SquareDto> getSquares(){

        List<Square>squares= squareRepository.findAll();
        List<SquareDto>dto=squares.stream().map(cube -> modelMapper.map(cube, SquareDto.class)).collect(Collectors.toList());//Square class ı quare dto ya dönüştürüp toList methodu ile aktarmak için kullanılmıştır.
        return dto;
    }

    }


