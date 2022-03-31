package com.test.springframework.data.api.grade.repogitory;

import com.test.springframework.domain.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepogitory extends JpaRepository<Grade,Integer> {
}
