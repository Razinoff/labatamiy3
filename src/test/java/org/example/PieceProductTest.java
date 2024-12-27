package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceProductTest {

    @Test
    void testConstructorAndGetters() {
        PieceProduct product = new PieceProduct("Candy", "Sweet candy", 0.1);

        assertEquals("Candy", product.getName()); // Проверка имени
        assertEquals("Sweet candy", product.getDescription()); // Проверка описания
        assertEquals(0.1, product.getWeightPerPiece()); // Проверка веса одной штуки
    }

    @Test
    void testEqualsAndHashCode() {
        PieceProduct product1 = new PieceProduct("Candy", "Sweet candy", 0.1);
        PieceProduct product2 = new PieceProduct("Candy", "Sweet candy", 0.1);
        PieceProduct product3 = new PieceProduct("Chocolate", "Dark chocolate", 0.2);

        assertEquals(product1, product2); // Объекты равны
        assertNotEquals(product1, product3); // Объекты не равны

        assertEquals(product1.hashCode(), product2.hashCode()); // Хэш-коды равны
        assertNotEquals(product1.hashCode(), product3.hashCode()); // Хэш-коды не равны
    }

    @Test
    void testToString() {
        PieceProduct product = new PieceProduct("Candy", "Sweet candy", 0.1);

        String expected = "PieceProduct{name='Candy', description='Sweet candy', weightPerPiece=0.1}";
        assertEquals(expected, product.toString()); // Проверка метода toString
    }
}