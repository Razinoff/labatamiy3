package GGWP;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.example.*;
import rofl.*;

public class countByFilterTest {
    // Создаем упаковку
    Packaging boxPackaging = new Packaging("Box", 0.5);
    Packaging bagPackaging = new Packaging("Bag", 0.3);

    // Создаем продукты с упаковками
    ProductOfBatch item1 = new PackagedPieceProduct("Candy", "Sweet", 0.1, 10, boxPackaging);
    ProductOfBatch item2 = new PackagedWeightedProduct("Flour", "White flour", 5.0, bagPackaging);
    ProductOfBatch item3 = new PackagedPieceProduct("Candy Bar", "Chocolate", 0.2, 5, boxPackaging);
    ProductOfBatch item4 = new PackagedPieceProduct("Flavored Candy", "Strawberry", 0.15, 8, boxPackaging);

    // Добавляем продукты в партию
    List<ProductOfBatch> items = Arrays.asList(item1, item2, item3, item4);
    ProductBatch batch = new ProductBatch("Mixed Products Batch", items);

    @Test
    public void testCountByFilter_CandyPrefix() {
        // Создаем фильтр для строк, начинающихся на "Candy"
        Filter filter = new BeginStringFilter("Candy");

        // Подсчитываем количество элементов, соответствующих фильтру
        long count = countByFilter.countByFilter(batch, filter);

        // Проверяем результат
        assertEquals(2, count);
    }

    @Test
    public void testCountByFilter_FlourPrefix() {
        // Создаем фильтр для строк, начинающихся на "Flour"
        Filter filter = new BeginStringFilter("Flour");

        // Подсчитываем количество элементов, соответствующих фильтру
        long count = countByFilter.countByFilter(batch, filter);

        // Проверяем результат
        assertEquals(1, count);
    }

    @Test
    public void testCountByFilter_NoMatches() {
        // Создаем фильтр для строк, начинающихся на "Chocolate"
        Filter filter = new BeginStringFilter("Chocolate");

        // Подсчитываем количество элементов, соответствующих фильтру
        long count = countByFilter.countByFilter(batch, filter);

        // Проверяем результат
        assertEquals(0, count);
    }

    @Test
    public void testCountByFilter_EmptyBatch() {
        // Создаем пустую партию
        ProductBatch emptyBatch = new ProductBatch("Empty Batch", List.of());

        // Создаем фильтр
        Filter filter = new BeginStringFilter("AnyPrefix");

        // Подсчитываем количество элементов
        long count = countByFilter.countByFilter(emptyBatch, filter);

        // Проверяем результат
        assertEquals(0, count);
    }

    @Test
    public void testCountByFilter_NullBatch() {
        // Проверка на выброс исключения при передаче null
        Filter filter = new BeginStringFilter("AnyPrefix");

        assertThrows(IllegalArgumentException.class, () -> {
            countByFilter.countByFilter(null, filter);
        });
    }
}

