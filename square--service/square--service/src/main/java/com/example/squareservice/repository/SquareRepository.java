package com.example.squareservice.repository;

import com.example.squareservice.entity.Square;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SquareRepository  extends JpaRepository<Square,Long> {
}
