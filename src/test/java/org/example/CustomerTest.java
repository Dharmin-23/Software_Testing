package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void reduceWallet_amt_EnoughBalance_ReturnsTrue() {
        Customer customer = new Customer("testUser", "testPassword");
        customer.increaseWallet_amt(500);
        assertTrue(customer.reduceWallet_amt(200));
        assertEquals(300.0, customer.getWallet_amt());
    }

    @Test
    void reduceWallet_amt_InsufficientBalance_ReturnsFalse() {
        Customer customer = new Customer("testUser", "testPassword");
        customer.increaseWallet_amt(100);
        assertFalse(customer.reduceWallet_amt(150));
        assertEquals(100.0, customer.getWallet_amt());
    }

    @Test
    void increaseWallet_amt_PositiveAmount_WalletUpdated() {
        Customer customer = new Customer("testUser", "testPassword");
        customer.increaseWallet_amt(300);
        assertEquals(1300.0, customer.getWallet_amt());
    }

    @Test
    void printCurrent_status_NormalStatus_ReturnsNormal() {
        Customer customer = new Customer("testUser", "testPassword");
        assertEquals("NORMAL", customer.printCurrent_status());
    }

    @Test
    void printCurrent_status_PrimeStatus_ReturnsPrime() {
        Customer customer = new Customer("testUser", "testPassword");
        customer.setCurrent_status(1);
        assertEquals("PRIME", customer.printCurrent_status());
    }

    @Test
    void printCurrent_status_EliteStatus_ReturnsElite() {
        Customer customer = new Customer("testUser", "testPassword");
        customer.setCurrent_status(2);
        assertEquals("ELITE", customer.printCurrent_status());
    }

    @Test
    void delivery_fee_NormalStatus_CorrectFee() {
        Customer customer = new Customer("testUser", "testPassword");
        assertEquals(100.0, customer.delivery_fee(1000));
    }

    @Test
    void delivery_fee_PrimeStatus_CorrectFee() {
        Customer customer = new Customer("testUser", "testPassword");
        customer.setCurrent_status(1);
        assertEquals(120.0, customer.delivery_fee(1000));
    }

    @Test
    void delivery_fee_EliteStatus_CorrectFee() {
        Customer customer = new Customer("testUser", "testPassword");
        customer.setCurrent_status(2);
        assertEquals(140.0, customer.delivery_fee(1000));
    }

    @Test
    void coupon_generator_NormalStatus_GeneratesCorrectCoupons() {
        Customer customer = new Customer("testUser", "testPassword");
        customer.setCurrent_status(0);
        customer.coupon_generator();
        assertEquals(0, customer.getCoupons().size());
    }

    @Test
    void coupon_generator_PrimeStatus_GeneratesCorrectCoupons() {
        Customer customer = new Customer("testUser", "testPassword");
        customer.setCurrent_status(1);
        customer.coupon_generator();
        assertEquals(2, customer.getCoupons().size());
    }

    @Test
    void coupon_generator_EliteStatus_GeneratesCorrectCoupons() {
        Customer customer = new Customer("testUser", "testPassword");
        customer.setCurrent_status(2);
        customer.coupon_generator();
        assertEquals(3, customer.getCoupons().size());
    }

    @Test
    void quantity_check_EnoughQuantityInCart_ReturnsTrue() {
        // Write appropriate setup for products, deals, and quantities in the cart
        Customer customer = new Customer("testUser", "testPassword");
        assertTrue(customer.quantity_check());
    }

    @Test
    void quantity_check_InsufficientQuantityInCart_ReturnsFalse() {
        // Write appropriate setup for products, deals, and quantities in the cart
        Customer customer = new Customer("testUser", "testPassword");
        assertFalse(customer.quantity_check());
    }

    // Add more test cases as needed for other methods and scenarios.
}