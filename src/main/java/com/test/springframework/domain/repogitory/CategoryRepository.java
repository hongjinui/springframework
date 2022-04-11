package com.test.springframework.domain.repogitory;

import com.test.springframework.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByCtgName(String ctgName);
}
