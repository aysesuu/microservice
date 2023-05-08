package com.example.backupservice.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CubeDto {
    private long id;
    private double value;
    private double numberOne;
    private double numberTwo;
    private double numberThree;
}
