package com.test.springframework.domain.repogitory;

import com.test.springframework.domain.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Integer> {
    Grade findByGrdName(String grdName);
}
