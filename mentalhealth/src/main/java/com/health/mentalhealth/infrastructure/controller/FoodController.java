package com.health.mentalhealth.infrastructure.controller;

import com.health.mentalhealth.domain.persistence.entity.Food;
import com.health.mentalhealth.domain.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getFoodById(@PathVariable Long id){
        return ResponseEntity.ok(foodService.getFoodById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAllFood(){
        return ResponseEntity.ok(foodService.getAllFood());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFoodById(@PathVariable Long id){
        foodService.deleteFood(id);
        return ResponseEntity.ok("");
    }

    @PostMapping
    public ResponseEntity<?> createFood(@RequestBody Food food){
        return ResponseEntity.ok(foodService.createFood(food));
    }

}
