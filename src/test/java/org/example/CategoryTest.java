package org.example;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class CategoryTest {

    @Test
    void getCategory_name_ReturnsCorrectName() {
        Category category = new Category("Electronics", 1);
        assertEquals("Electronics", category.getCategory_name());
    }

    @Test
    void getCategory_id_ReturnsCorrectId() {
        Category category = new Category("Clothing", 2);
        assertEquals(2, category.getCategory_id());
    }

    @Test
    void printCategory_PrintsCorrectInformation() {
        Category category = new Category("Books", 3);
        assertEquals("Category name: Books\nCategory Id: 3", getPrintedOutput(category::printCategory));
    }

    private String getPrintedOutput(Runnable action) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Perform the action that prints to System.out
        action.run();

        // Reset System.out to the original PrintStream
        System.setOut(originalOut);

        // Return the captured output
        return outputStream.toString().trim();
    }
}