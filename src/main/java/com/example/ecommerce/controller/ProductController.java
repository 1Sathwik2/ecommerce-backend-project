package com.example.ecommerce.controller;




import com.example.ecommerce.service.ProductService;
import com.example.ecommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    ProductService pro;
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {

        return new ResponseEntity<>(pro.getAllProducts(), HttpStatus.OK);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<Product>  getProductById(@PathVariable int id) {
         Product Pro = pro.getProductById(id);
             if (Pro != null) {
                 return new ResponseEntity<>(Pro, HttpStatus.OK);
             }
             else{
                 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
             }

    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getImagebyId(@PathVariable int id) {
        Product Pro = pro.getProductById(id);
        return  new ResponseEntity<>(Pro.getImage(), HttpStatus.OK);
    }
    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@RequestPart Product product , @RequestPart MultipartFile imageFile) {
        Product savedProduct = null;
        try {
            savedProduct = pro.createOrUpdateProduct(product, imageFile);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    @DeleteMapping ("/product/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable int id){
        Product deletedProduct = null;
        deletedProduct = pro.deleteProduct(id);
        if(deletedProduct != null){
            return new ResponseEntity<>(deletedProduct, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        

    }
    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart Product product, @RequestPart MultipartFile imageFile) {
        Product updatedProduct = null;
        try{
           updatedProduct =  pro.createOrUpdateProduct(product,imageFile);
           return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
        }
        catch(IOException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


}



