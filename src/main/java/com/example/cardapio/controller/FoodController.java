package com.example.cardapio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardapio.food.Food;
import com.example.cardapio.food.FoodRepository;
import com.example.cardapio.food.FoodRequestDTO;
import com.example.cardapio.food.FoodResponseDTO;

@RestController // indicate this class as controller
@RequestMapping("food") // to create an endpoint as food (route)
public class FoodController {
    
    @Autowired // to inject dependencies on class "FoodControl" using the repository
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data) {
        Food foodData = new Food(data);
        repository.save(foodData);
        return;   
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping // when us use a endpoint 'food' as get method, the method 'getAll' it will be called
    public List<FoodResponseDTO> getAll() { // get all data inside of database

        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList(); // "stream()" -> get all data from repository using "findAll()" and we will use "map()" to create a data transfer object (DTO) in each method
        return foodList;
    }

}
