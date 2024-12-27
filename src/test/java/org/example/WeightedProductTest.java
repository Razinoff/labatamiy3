package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeightedProductTest {

    @Test
    void testToString() {
        WeightedProduct weightedProduct = new WeightedProduct("Apples", "Fresh apples");
        assertEquals("WeightedProduct{name='Apples', description='Fresh apples'}", weightedProduct.toString());
    }
    @Test
    void testEqualsAndHashCode() {
        WeightedProduct product1 = new WeightedProduct("Apples", "Fresh apples");
        WeightedProduct product2 = new WeightedProduct("Apples", "Fresh apples");

        assertEquals(product1, product2); // Проверка equals
        assertEquals(product1.hashCode(), product2.hashCode()); // Проверка hashCode
    }

}
