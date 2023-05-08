package com.example.cubeservice.repository;

import com.example.cubeservice.entity.Cube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CubeRepository extends JpaRepository<Cube, Long> {

}
