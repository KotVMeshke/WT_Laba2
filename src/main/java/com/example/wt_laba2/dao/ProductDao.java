package com.example.wt_laba2.dao;

import com.example.wt_laba2.bean.Product;
import com.example.wt_laba2.exception.DAOException;

import java.io.InputStream;
import java.util.List;

/**
 * Interface handling product-related database operations.
 */
public interface ProductDao {

    /**
     * Retrieves a list of products by category.
     * @param category The category of products to retrieve.
     * @return List of products belonging to the specified category.
     * @throws DAOException if there's an error while fetching products.
     */
    List<Product> GetProductListByCat(String category) throws DAOException;

    /**
     * Retrieves all products available in the database.
     * @return List of all available products.
     * @throws DAOException if there's an error while fetching products.
     */
    List<Product> GetAllProduct() throws DAOException;

    /**
     * Sets a discount for a specific product.
     * @param productId The ID of the product for which the discount is to be set.
     * @param discountSize The discount percentage to be set.
     * @throws DAOException if there's an error while setting the discount.
     */
    void SetDiscount(int productId, int discountSize) throws DAOException;

    /**
     * Adds a new product to the database.
     * @param name The name of the product.
     * @param price The price of the product.
     * @param category The category of the product.
     * @param file InputStream representing the image file of the product.
     * @throws DAOException if there's an error while adding the product.
     */
    void AddProduct(String name, String price, String category, InputStream file) throws DAOException;

    /**
     * Retrieves a product by its ID.
     * @param id The ID of the product to retrieve.
     * @return The product corresponding to the given ID.
     * @throws DAOException if there's an error while fetching the product.
     */
    Product GetProductById(int id) throws DAOException;
}
