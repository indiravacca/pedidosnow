package com.techlab.pedidosnow.controller;

import com.techlab.pedidosnow.model.Product;
import com.techlab.pedidosnow.persistence.ProductRespository;
import com.techlab.pedidosnow.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRespository productRepository;

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id){
        return productService.findById(id);
    }

    @PostMapping
    public Product creatProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping
    public List<Product> getProduct(){
        return productService.listAll();
    }

    @DeleteMapping()
    public String deleteProduct(@RequestParam Long id) {
       return productService.removeById(id);
    }

    @PatchMapping("/{id}")
    public Product patchProduct(@PathVariable Long id, @RequestBody Map<String, Object> fields){
        return productService.patchProducto(id, fields);
    }
}
