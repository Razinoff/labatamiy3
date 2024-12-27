package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PackagedWeightedProductTest {

    @Test
    void testWeights() {
        Packaging packaging = new Packaging("Bag", 0.3);
        PackagedWeightedProduct packaged = new PackagedWeightedProduct(
                "Flour", "White flour", 5.0, packaging
        );

        assertEquals(5.0, packaged.getNetWeight(), "Net weight should match the product's weight");
        assertEquals(5.3, packaged.getGrossWeight(), "Gross weight should include packaging weight");
    }

    @Test
    void testEqualsAndHashCode() {
        Packaging packaging1 = new Packaging("Bag", 0.3);
        Packaging packaging2 = new Packaging("Bag", 0.3);

        PackagedWeightedProduct packaged1 = new PackagedWeightedProduct(
                "Flour", "White flour", 5.0, packaging1
        );
        PackagedWeightedProduct packaged2 = new PackagedWeightedProduct(
                "Flour", "White flour", 5.0, packaging2
        );

        assertEquals(packaged1, packaged2, "Equal objects should be considered equal");
        assertEquals(packaged1.hashCode(), packaged2.hashCode(), "Equal objects should have the same hash code");
    }

    @Test
    void testToString() {
        Packaging packaging = new Packaging("Bag", 0.3);
        PackagedWeightedProduct packagedProduct = new PackagedWeightedProduct(
                "Flour", "White flour", 5.0, packaging
        );

        String expected = "PackagedWeightedProduct{name='Flour', description='White flour', netWeight=5.0, grossWeight=5.3, packaging=Packaging{name='Bag', weight=0.3}}";
        assertEquals(expected, packagedProduct.toString(), "String representation should match the expected format");
    }
}
