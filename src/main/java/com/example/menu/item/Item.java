package com.example.menu.item;

import lombok.Data;
import lombok.Getter;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Data
public class Item {

    @Id @Getter
    private final Long id;

    @NotNull(message = "name is required")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "name must be a string")
    private final String name;

    @NotNull(message = "price is required")
    @Positive(message = "price must be positive")
    private final Long price;

    @NotNull(message = "description is required")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "description must be a string")
    private final String description;

    @NotNull(message = "image is required")
    @URL(message = "image must be a URL")
    private final String image;



    public Item updateWith(Item item) {
        return new Item(
                this.id,
                item.name,
                item.price,
                item.description,
                item.image);
    }
}
