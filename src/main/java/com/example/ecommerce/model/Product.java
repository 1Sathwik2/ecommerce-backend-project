package com.example.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String brand;
    @JsonFormat(shape =  JsonFormat.Shape.STRING,pattern = "dd-MM-YYYY")
    private Date releaseDate;
    private BigDecimal price;
    private Integer quantity;
    private String category;
    private Boolean available;
    private String imageName;
    private String imageType;
    @Lob
    private byte[] image;

}
