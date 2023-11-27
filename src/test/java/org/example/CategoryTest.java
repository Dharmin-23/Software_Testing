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
        // Original behavior with output capture
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Creating an instance of Category
        Category category = new Category("Books", 1);

        // Calling the method you want to test
        category.printCategory();

        // Checking if the console output contains the expected content
        assertEquals("Category name: Books\nCategory Id: 1", outContent.toString().trim());

        // Clean up by resetting System.out
        System.setOut(System.out);
    }

    @Test
    void printCategory_DoesNotPrintAnything() {
        // Mutant: (removed call to java/io/PrintStream::println)
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Creating an instance of Category
        Category category = new Category("Books", 1);

        // Mutant: (removed call to java/io/PrintStream::println)
        // This method should not print anything
        category.printCategory();

        // Checking if the console output is empty
        assertEquals("", outContent.toString().trim());

        // Clean up by resetting System.out
        System.setOut(System.out);
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



//import org.junit.jupiter.api.Test;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//import static org.junit.jupiter.api.Assertions.*;
//
//class CategoryTest {
//
//    @Test
//    void getCategoryName_ReturnsCategoryName() {
//        // Original behavior
//        Category category = new Category("Electronics", 1);
////        assertEquals("Electronics", category.getCategory_name());
//        assertNotNull(category.getCategory_name());
//    }
//
//    @Test
//    void getCategoryID_ReturnsCategoryID() {
//        Category category = new Category("Electronics", 1);
////        assertEquals(1, category.getCategory_id());
//        assertTrue(category.getCategory_id() == 0 || category.getCategory_id() == 1); // Ensuring that the returned value is either 0 or 1
//    }
//
//    @Test
//    void getCategoryName_ReturnsNonNullForNullInput() {
//        // Mutant: (if (x != null) null else throw new RuntimeException)
//        Category category = new Category("Electronics", 1);
//        assertNotNull(category.getCategory_name());
//    }
//
//    @Test
//    void getCategoryName_ReturnsNullForNonNullInput() {
//        // Mutant: (if (x != null) null else throw new RuntimeException)
//        Category category = new Category(null, 1);
//        assertNull(category.getCategory_name());
//    }
//
//    @Test
//    void getCategoryName_ReturnsOneForZeroInput() {
//        // Mutant: (x == 0 ? 1 : 0)
//        Category category = new Category("Electronics", 0);
//        assertEquals(1, category.getCategory_id());
//    }
//
//    @Test
//    void printCategory_PrintsCategoryDetails() {
//        // Original behavior with output capture
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//
//        Category category = new Category("Electronics", 1);
//        category.printCategory();
//
//        assertEquals("Category name: Electronics\nCategory Id: 1", outContent.toString().trim());
//
//        // Clean up by resetting System.out
//        System.setOut(System.out);
//    }
//
//    @Test
//    void printCategory_DoesNotPrintCategoryDetails() {
//        // Mutant: (removed call to java/io/PrintStream::println)
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//
//        Category category = new Category("Electronics", 1);
//        category.printCategory();
//
//        assertEquals("", outContent.toString().trim());
//
//        // Clean up by resetting System.out
//        System.setOut(System.out);
//    }
//
//    @Test
//    void printCategory_PrintsCategoryDetailsWithPrintlnRemoved() {
//        // Mutant: (removed call to java/io/PrintStream::println)
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//
//        Category category = new Category("Electronics", 1);
//        // Mutant: (removed call to java/io/PrintStream::println)
//        category.printCategory();
//
//        assertEquals("", outContent.toString().trim());
//
//        // Clean up by resetting System.out
//        System.setOut(System.out);
//    }
//}
