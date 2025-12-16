package com.techlab.pedidosnow.service;

import com.techlab.pedidosnow.exceptions.ProductNotFoundException;
import com.techlab.pedidosnow.model.Product;
import com.techlab.pedidosnow.persistence.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRespository productRepository;


    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public String removeById(Long id) {
        if (productRepository.existsById(id)){
            productRepository.deleteById(id);
            return "Se elimino el producto";
        }else{
            return "Producto no encontrado: "+id;
        }
    }

    @Transactional
    public Product patchProducto(Long id, Map<String, Object> fields) {

        Product producto = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        fields.forEach((key, value) -> {
            switch (key) {
                case "name":
                    producto.setName((String) value);
                    break;
                case "price":
                    producto.setPrice(Double.valueOf(value.toString()));
                    break;
                case "stock":
                    producto.setStock(Integer.valueOf(value.toString()));
                    break;
                case "description":
                    producto.setDescription((String) value);
                    break;
                case "imageUrl":
                    producto.setImageUrl((String) value);
                    break;
            }
        });

        return productRepository.save(producto);
    }
}
