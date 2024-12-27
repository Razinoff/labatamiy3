package org.example;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ProductBatchTest {

    @Test
    void testGetTotalWeight() {
        // Создаем упаковку
        Packaging boxPackaging = new Packaging("Box", 0.5);
        Packaging bagPackaging = new Packaging("Bag", 0.3);

        // Создаем продукты с упаковками
        ProductOfBatch item1 = new PackagedPieceProduct("Candy", "Sweet", 0.1, 10, boxPackaging);
        ProductOfBatch item2 = new PackagedWeightedProduct("Flour", "White flour", 5.0, bagPackaging);

        // Добавляем продукты в партию
        List<ProductOfBatch> items = Arrays.asList(item1, item2);
        ProductBatch batch = new ProductBatch("Mixed Products Batch", items);

        // Рассчитываем общий вес
        double totalWeight = batch.getTotalWeight();

        // Ожидаемый общий вес = (0.1 * 10) + 0.5 (упаковка для Candy) + 5.0 + 0.3 (упаковка для Flour)
        assertEquals(6.8, totalWeight, 0.0001, "Total weight should be 5.8");
    }

    @Test
    void testEquals() {
        // Создаем упаковки
        Packaging boxPackaging = new Packaging("Box", 0.5);
        Packaging bagPackaging = new Packaging("Bag", 0.3);

        // Создаем продукты для двух партий
        ProductOfBatch item1 = new PackagedPieceProduct("Candy", "Sweet", 0.1, 10, boxPackaging);
        ProductOfBatch item2 = new PackagedWeightedProduct("Flour", "White flour", 5.0, bagPackaging);

        // Создаем две одинаковые партии
        List<ProductOfBatch> items1 = Arrays.asList(item1, item2);
        List<ProductOfBatch> items2 = Arrays.asList(item1, item2);

        ProductBatch batch1 = new ProductBatch("Batch 1", items1);
        ProductBatch batch2 = new ProductBatch("Batch 1", items2);

        // Создаем партию с другим описанием
        ProductBatch batch3 = new ProductBatch("Batch 2", items1);

        // Проверяем равенство
        assertEquals(batch1, batch2);
        assertNotEquals(batch1, batch3);
    }
}
