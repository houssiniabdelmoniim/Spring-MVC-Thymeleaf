package org.example.springmvcthymeleaf.repository;

import org.example.springmvcthymeleaf.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
