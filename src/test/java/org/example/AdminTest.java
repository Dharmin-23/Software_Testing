package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

class AdminTest {

    @Test
    void addCategory_UniqueCategory_AddsCategoryToStore() {
        // Mocking user input for testing
        mockUserInput("1\nNewCategoryName\n1\nProduct1\n1.0\n10\nSpecs\n");

        Admin admin = new Admin("admin", "password");
        admin.add_category();

        assertTrue(Store.category_Search(1));
    }

    @Test
    void addCategory_NonUniqueCategory_PromptsForNewCategoryID() {
        // Mocking user input for testing
        mockUserInput("1\nExistingCategoryName\n1\nProduct1\n1.0\n10\nSpecs\n");

        Admin admin = new Admin("admin", "password");
        admin.add_category();

        assertFalse(Store.category_Search(1));
    }

    @Test
    void addProduct_AddsProductToCategory() {
        // Mocking user input for testing
        mockUserInput("Product1\n1.0\n10\nSpecs\n");

        Admin admin = new Admin("admin", "password");
        Category category = new Category("TestCategory", 1);
        admin.add_product(category);

        assertEquals(1, Store.Category_product.get(category).size());
    }

    @Test
    void deleteCategory_RemovesCategoryFromStore() {
        Admin admin = new Admin("admin", "password");
        Category category = new Category("TestCategory", 1);

        Store.Category_product.put(category, new ArrayList<>());

        admin.delete_category(category);

        assertNull(Store.Category_product.get(category));
    }

    @Test
    void deleteProduct_RemovesProductFromCategory() {
        // Mocking user input for testing
        mockUserInput("1.0\n");

        Admin admin = new Admin("admin", "password");
        Category category = new Category("TestCategory", 1);
        Product product = new Product("TestCategory", 1, 1.0, "Product1", 10.0, 5, "Specs");

        Store.Category_product.put(category, new ArrayList<>());
        Store.Category_product.get(category).add(product);

        admin.delete_product(category);

        assertEquals(0, Store.Category_product.get(category).size());
    }

    @Test
    void addGiveAwayDeal_AddsDealToStore() {
        // Mocking user input for testing
        mockUserInput("1.0\n2.0\n3.0\n4.0\n5.0\n");

        Admin admin = new Admin("admin", "password");
        admin.add_give_away_deal();

        assertTrue(Store.Deals.containsKey(1.0));
    }

    // Helper method to mock user input
    private void mockUserInput(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}

