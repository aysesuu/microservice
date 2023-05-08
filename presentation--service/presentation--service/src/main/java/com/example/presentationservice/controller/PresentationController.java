package com.example.presentationservice.controller;

import com.example.presentationservice.dto.response.CubeDto;
import com.example.presentationservice.dto.response.SquareDto;
import com.example.presentationservice.service.PresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@CrossOrigin (origins = "*",methods = {RequestMethod.OPTIONS,RequestMethod.POST},allowedHeaders = "*")
public class PresentationController {
    private final PresentationService presentationService;

    public PresentationController(PresentationService presentationService) {
        this.presentationService = presentationService;
    }
   @PostMapping("/s")
    public String kareGoster (@RequestBody SquareDto squareDto) throws URISyntaxException {
       URI uri = new URI("http://localhost:8095/");

       RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<SquareDto> responseEntity = restTemplate.postForEntity(uri,squareDto, SquareDto.class);
        SquareDto squareDto1= responseEntity.getBody();
        double value =presentationService.findById(squareDto1.getId());
        return "sayi1=  "+squareDto1.getNumberOne()+"  -----  "+"sayi2=  "+squareDto1.getNumberTwo()+"  -----  "+"karesi"+value;
    }





    @PostMapping("/c")
    public String kupGoster(@RequestBody CubeDto cubeDto) throws URISyntaxException {
        URI uri = new URI("http://localhost:8090/");
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<CubeDto> response = restTemplate.postForEntity(uri,cubeDto, CubeDto.class);
        CubeDto cubeDto1 = response.getBody();
        double value = presentationService.findById(cubeDto1.getId());
        return "sayi1=  "+cubeDto1.getNumberOne()+"  -----  "+"sayi2=  "+cubeDto1.getNumberTwo()+"  -----  "+"sayi3=  "+cubeDto1.getNumberThree()+"-----"+"kup"+value;
    }
    @GetMapping("/a")
    public String deneme(){
        return "hello";
    }

}
