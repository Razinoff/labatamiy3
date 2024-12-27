package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testEqualsAndHashCode() {
        Product product1 = new Product("Laptop", "Black laptop");
        Product product2 = new Product("Laptop", "Black laptop");

        assertEquals(product1, product2);
        assertEquals(product1.hashCode(), product2.hashCode());
    }

    @Test
    void testToString() {
        Product product = new Product("Phone", "Smartphone with 220GB");
        assertEquals("Product{name='Phone', description='Smartphone with 220GB'}", product.toString());
    }
}
