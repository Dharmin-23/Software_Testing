package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    @Test
    void customerSearch_ValidCredentials_ReturnsTrue() {
        Store.Customer_record.clear();
        Customer customer = new Customer("JohnDoe", "password");
        Store.Customer_record.put(1, customer);

        assertTrue(Store.customer_Search("JohnDoe", "password"));
    }

    @Test
    void customerSearch_InvalidCredentials_ReturnsFalse() {
        Store.Customer_record.clear();
        Customer customer = new Customer("JohnDoe", "password");
        Store.Customer_record.put(1, customer);

        assertFalse(Store.customer_Search("JohnDoe", "wrongpassword"));
    }

    @Test
    void categorySearch_ExistingCategoryID_ReturnsTrue() {
        Store.Category_product.clear();
        Category category = new Category("Electronics", 1);
        Store.Category_product.put(category, new ArrayList<>());

        assertTrue(Store.category_Search(1));
    }

    @Test
    void categorySearch_NonExistingCategoryID_ReturnsFalse() {
        Store.Category_product.clear();
        Category category = new Category("Electronics", 1);
        Store.Category_product.put(category, new ArrayList<>());

        assertFalse(Store.category_Search(2));
    }

    @Test
    void productSearch_ExistingProductID_ReturnsTrue() {
        Store.Category_product.clear();
        Category category = new Category("Electronics", 1);
        Product product = new Product(category.getCategory_name(), category.getCategory_id(), 123.45, "Smartphone", 499.99, 50, "4GB RAM, 64GB Storage");
        Store.Category_product.put(category, new ArrayList<>());
        Store.Category_product.get(category).add(product);

        assertTrue(Store.product_search(category, 123.45));
    }

    @Test
    void productSearch_NonExistingProductID_ReturnsFalse() {
        Store.Category_product.clear();
        Category category = new Category("Electronics", 1);
        Product product = new Product(category.getCategory_name(), category.getCategory_id(), 123.45, "Smartphone", 499.99, 50, "4GB RAM, 64GB Storage");
        Store.Category_product.put(category, new ArrayList<>());
        Store.Category_product.get(category).add(product);

        assertFalse(Store.product_search(category, 678.90));
    }

    @Test
    void prodSearch_ExistingProductID_ReturnsTrue() {
        Store.Category_product.clear();
        Category category = new Category("Electronics", 1);
        Product product = new Product(category.getCategory_name(), category.getCategory_id(), 123.45, "Smartphone", 499.99, 50, "4GB RAM, 64GB Storage");
        Store.Category_product.put(category, new ArrayList<>());
        Store.Category_product.get(category).add(product);

        assertTrue(Store.prod_search(123.45));
    }

    @Test
    void prodSearch_NonExistingProductID_ReturnsFalse() {
        Store.Category_product.clear();
        Category category = new Category("Electronics", 1);
        Product product = new Product(category.getCategory_name(), category.getCategory_id(), 123.45, "Smartphone", 499.99, 50, "4GB RAM, 64GB Storage");
        Store.Category_product.put(category, new ArrayList<>());
        Store.Category_product.get(category).add(product);

        assertFalse(Store.prod_search(678.90));
    }
}
