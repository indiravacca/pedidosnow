package com.techlab.pedidosnow.controller;

import com.techlab.pedidosnow.model.Product;
import com.techlab.pedidosnow.persistence.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRespository productRepository;

    @PostMapping
    public Product creatUser(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping
    public List<Product> getUsers(){
        return productRepository.findAll();
    }

    @DeleteMapping()
    public String deleteUser(@RequestParam Long id){
        if (productRepository.existsById(id)){
            productRepository.deleteById(id);
            return "Se elimino el producto";
        }else{
            return "Producto no encontrado: "+id;
        }
    }
}
