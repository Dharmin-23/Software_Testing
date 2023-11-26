package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getProductDetails_ReturnsCorrectDetails() {
        Product product = new Product("Electronics", 1, 123.45, "Smartphone", 499.99, 50, "4GB RAM, 64GB Storage");
        assertEquals("Smartphone", product.getProduct_name());
        assertEquals(499.99, product.getPrice());
        assertEquals(123.45, product.getProduct_id());
        assertEquals("4GB RAM, 64GB Storage", product.getSpecifications());
        assertEquals(50, product.getQuantity());
    }

    @Test
    void setProductDetails_ModifiesProductDetails() {
        Product product = new Product("Clothing", 2, 678.90, "T-Shirt", 19.99, 100, "Cotton");
        product.setProduct_name("New T-Shirt");
        product.setPrice(29.99);
        product.setSpecifications("Polyester");
        product.setQuantity(150);

        assertEquals("New T-Shirt", product.getProduct_name());
        assertEquals(29.99, product.getPrice());
        assertEquals("Polyester", product.getSpecifications());
        assertEquals(150, product.getQuantity());
    }

    @Test
    void printProduct_PrintsProductDetails() {
        Product product = new Product("Books", 3, 987.65, "Java Programming", 59.99, 30, "Author: John Doe");
        String expectedOutput = "Product name: Java Programming\nProduct price per unit: 59.99\nProduct Id: 987.65\nProduct Specifications: Author: John Doe\nQuantity: 30";

        assertEquals(expectedOutput, getPrintedOutput(() -> product.printProduct()));
    }

    @Test
    void createProductWithDiscounts_ReturnsProductWithDiscounts() {
        Product product = new Product("Electronics", 1, 123.45, "Smartphone", 499.99, 50, "4GB RAM, 64GB Storage");
        product.setDiscount_normal(5.0);
        product.setDiscount_prime(10.0);
        product.setDiscount_elite(15.0);

        assertEquals(5.0, product.getDiscount_normal());
        assertEquals(10.0, product.getDiscount_prime());
        assertEquals(15.0, product.getDiscount_elite());
    }

    // Helper method to capture printed output
    private String getPrintedOutput(Runnable action) {
        StringBuilder printedOutput = new StringBuilder();
        System.setOut(new java.io.PrintStream(System.out) {
            @Override
            public void println(String x) {
                printedOutput.append(x).append("\n");
            }
        });

        action.run();

        return printedOutput.toString().trim();
    }
}
