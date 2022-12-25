package ru.geekbrains.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import ru.geekbrains.model.Product;
import ru.geekbrains.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product getExpensive() {
        return productRepository.getExpensive();
    }

    public Product getCheap() {
        return productRepository.getCheap();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAllByCostBetween(Integer min, Integer max) {
        return productRepository.findAllByCostBetween(min, max); // так у учителя
    }

}
