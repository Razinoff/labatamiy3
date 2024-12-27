package org.example;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackagedPieceProductTest {

    @Test
    void testWeightsAndQuantity() {
        Packaging packaging = new Packaging("Box", 0.5);
        PackagedPieceProduct packaged = new PackagedPieceProduct("Candy", "Sweet candies", 0.1, 10, packaging);

        assertEquals(10, packaged.getQuantity(), "Количество товара не совпадает.");
        assertEquals(1.0, packaged.getNetWeight(), 0.0001, "Масса нетто рассчитана неверно.");
        assertEquals(1.5, packaged.getGrossWeight(), 0.0001, "Масса брутто рассчитана неверно.");
    }

    @Test
    void testEqualsAndHashCode() {
        Packaging packaging = new Packaging("Box", 0.5);
        PackagedPieceProduct packaged1 = new PackagedPieceProduct("Candy", "Sweet candies", 0.1, 10, packaging);
        PackagedPieceProduct packaged2 = new PackagedPieceProduct("Candy", "Sweet candies", 0.1, 10, packaging);
        PackagedPieceProduct packaged3 = new PackagedPieceProduct("Candy", "Sweet candies", 0.1, 5, packaging);

        assertEquals(packaged1, packaged2, "Два одинаковых объекта должны быть равны.");
        assertNotEquals(packaged1, packaged3, "Объекты с разным количеством не должны быть равны.");
        assertEquals(packaged1.hashCode(), packaged2.hashCode(), "HashCode одинаковых объектов должен совпадать.");
    }

    @Test
    void testToString() {
        Packaging packaging = new Packaging("Box", 0.5);
        PackagedPieceProduct packagedProduct = new PackagedPieceProduct("Candy", "Sweet candies", 0.1, 10, packaging);

        String expected = "PackagedPieceProduct{name='Candy', description='Sweet candies', weightPerPiece=0.1, quantity=10, packaging=Packaging{name='Box', weight=0.5}}";
        assertEquals(expected, packagedProduct.toString(), "Метод toString() вернул неверное значение.");
    }

    @Test
    void testEdgeCases() {
        Packaging packaging = new Packaging("Light Box", 0.1);
        PackagedPieceProduct packaged = new PackagedPieceProduct("Paper", "Thin sheets", 0.01, 0, packaging);

        assertEquals(0, packaged.getNetWeight(), "Масса нетто для нулевого количества должна быть 0.");
        assertEquals(0.1, packaged.getGrossWeight(), "Масса брутто для нулевого количества должна быть равна массе упаковки.");
    }
}
