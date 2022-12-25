package ru.geekbrains.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.geekbrains.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    void deleteById(Long id);

    @Query("select c from Product c where c.cost = (select max(cc.cost) from Product cc)")
    Product getExpensive();

    @Query("select c from Product c where c.cost = (select min(cc.cost) from Product cc)")
    Product getCheap();

    List<Product> findAllByCostBetween(Integer min, Integer max);

}
