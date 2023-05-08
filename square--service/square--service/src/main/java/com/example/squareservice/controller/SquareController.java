package com.example.squareservice.controller;

import com.example.squareservice.dto.SquareDto;
import com.example.squareservice.entity.Square;
import com.example.squareservice.service.SquareService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SquareController {
    private  final SquareService squareService;

    public SquareController(SquareService squareService) {
        this.squareService = squareService;
    }

    /*@GetMapping("/{num1}/{num2}")
    public long kareHesaplama(@PathVariable double num1, @PathVariable double num2){
        Square response =squareService.save(num1,num2);

        return response.getId();
    }*/
    @PostMapping("/")
    public ResponseEntity<SquareDto> save(@RequestBody SquareDto square){
        System.out.println("access success");
        SquareDto resultSquare=squareService.save(square);
        return ResponseEntity.ok(resultSquare);
    }
    @GetMapping("/getAllCube")
    public ResponseEntity<List<SquareDto>> getCube(){
        List<SquareDto> squares=squareService.getSquares();
        return ResponseEntity.ok(squares);
    }
}
