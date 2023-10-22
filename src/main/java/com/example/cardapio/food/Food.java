package com.example.cardapio.food;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Table(name = "foods") // "foods" is a table name on database "food"
@Entity(name = "foods") // Entity name is also "foods"
@Getter // Generate a get method for each properties
@NoArgsConstructor // Declare Constructor there's no one else argument
@AllArgsConstructor // Declare a constructor there are all arguments 
@EqualsAndHashCode(of = "id") // Indicate "Id" is a unique representation in Food
public class Food {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private Integer price;  

    // A new constructor
    public Food(FoodRequestDTO data) {
        this.image = data.image();
        this.price = data.price();
        this.title = data.title();
    } 

}
