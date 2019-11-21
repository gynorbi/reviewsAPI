package com.udacity.course3.reviews.jpa;

import com.udacity.course3.reviews.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query(nativeQuery = true,
            value = "SELECT AVG(CAST(reviews.score AS DECIMAL(10,4))) FROM products LEFT JOIN reviews ON products.id=reviews.product_id WHERE products.id=:productId")
    Double getAverageScoreById(Integer productId);
}
