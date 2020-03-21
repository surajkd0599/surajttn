package com.example.project.ecommerce.repos;

import com.example.project.ecommerce.model.Product;
import com.example.project.ecommerce.model.ProductCategory;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("from ProductCategory pc where pc.categoryName=:name")
    List<Object[]> findByName(@Param("name") String name);

    @Query("Select productName from Product")
    List<Object[]> findProduct();

    //Query for categoryId
    @Query("Select categoryId from ProductCategory where categoryName=:categoryName")
    Long categoryId(@Param("categoryName") String categoryName);
    //Query for productId
    @Query("Select productId from Product where productName=:productName")
    Long productId(@Param("productName") String productName);

    //Query to find category
    @Query(value = "Select category_name from product_category where product_id=:productId",nativeQuery = true)
    List<Object[]> findCategory(@Param("productId") Long productId);

    //Query to find variation

    @Query(value = "Select * from product_variation where category_id=:categoryId",nativeQuery = true)
    List<Object[]> findVariation(@Param("categoryId") Long categoryId);

    //Query to find low to high based on price

    @Query(value = "Select * from product_variation where category_id=:categoryId ORDER BY price ASC "
            ,nativeQuery = true)
    List<Object[]> priceLowToHigh(@Param("categoryId") Long categoryId);

    //Query to find high to low based on price
    @Query(value = "Select * from product_variation where category_id=:categoryId ORDER BY price DESC "
            ,nativeQuery = true)
    List<Object[]> priceHighToLow(@Param("categoryId") Long categoryId);
}
