package org.example;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PackagingTest {

    @Test
    void testEqualsAndHashCode() {
        Packaging packaging1 = new Packaging("XBox", 0.5);
        Packaging packaging2 = new Packaging("XBox", 0.5);

        assertEquals(packaging1, packaging2);
        assertEquals(packaging1.hashCode(), packaging2.hashCode());
    }

    @Test
    void testToString() {
        Packaging packaging = new Packaging("Pigmen", 0.2);
        assertEquals("Packaging{name='Pigmen', weight=0.2}", packaging.toString());
    }
}

