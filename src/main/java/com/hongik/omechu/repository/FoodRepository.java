package com.hongik.omechu.repository;

import com.hongik.omechu.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
