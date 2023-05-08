package com.example.cubeservice.controller;

import com.example.cubeservice.dto.CubeDto;
import com.example.cubeservice.service.CubeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class CubeController {

    private final CubeService cubeService;

    public CubeController(CubeService cubeService) {

        this.cubeService = cubeService;
    }

    @PostMapping("/")
    public ResponseEntity<CubeDto> save(@RequestBody CubeDto cube){
        CubeDto resultCube=cubeService.save(cube);
            return ResponseEntity.ok(resultCube);
    }

}



















