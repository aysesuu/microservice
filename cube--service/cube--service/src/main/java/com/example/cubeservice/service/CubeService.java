package com.example.cubeservice.service;

import com.example.cubeservice.dto.CubeDto;
import com.example.cubeservice.entity.Cube;
import com.example.cubeservice.repository.CubeRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@Service
public class CubeService {
    @Autowired
    private ModelMapper modelMapper;
    final private CubeRepository cubeRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    CubeService(CubeRepository cubeRepository, KafkaTemplate<String, String> kafkaTemplate) {
        this.cubeRepository = cubeRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    private static final Logger logger= LoggerFactory.getLogger(CubeService.class);


    public CubeDto save (CubeDto cubeDto){
        try {

            Cube cube=modelMapper.map(cubeDto,Cube.class);
            cube.setValue(cube.getNumberOne() * cube.getNumberTwo() * cube.getNumberThree());
            this.kafkaTemplate.send("cube-topic" , LocalDateTime.now()+"",cube.getNumberOne()+" ,"+cube.getNumberTwo()+" ,"+cube.getNumberThree());
            return modelMapper.map(cubeRepository.save(cube),CubeDto.class);
        }
       catch (Exception exception){
           logger.error(exception.getMessage());

       }
        return null;

    }

    public List<CubeDto> getCubes(){
        List<Cube>cubes= cubeRepository.findAll();
        List<CubeDto>dto=cubes.stream().map(cube -> modelMapper.map(cube, CubeDto.class)).collect(Collectors.toList());//Cube class ı cube dto ya dönüştürüp toList methodu ile aktarmak için kullanılmıştır.
        return dto;
    }


}















