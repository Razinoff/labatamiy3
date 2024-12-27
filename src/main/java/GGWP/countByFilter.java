package GGWP;

import org.example.ProductBatch;
import rofl.Filter;

public class countByFilter {
    // Метод для подсчета элементов, удовлетворяющих фильтру
    public static long countByFilter(ProductBatch productBatch, Filter filter) {
        if (productBatch == null || productBatch.getPackagedItems() == null) {
            throw new IllegalArgumentException("Product batch or its items cannot be null");
        }

        return productBatch.getPackagedItems().stream()
                .map(item -> (String) item.getName()) // Приведение к строке
                .filter(filter::apply)               // Применение фильтра
                .count();                            // сколько подходит
    }
}

