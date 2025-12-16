package com.techlab.pedidosnow.persistence;

import com.techlab.pedidosnow.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRespository extends JpaRepository<Product, Long> {
}
