package org.example;

import java.util.List;
import java.util.Objects;


public class ProductBatch {
    private final String description;
    private final List<ProductOfBatch> packagedItems;

    public ProductBatch(String description, List<ProductOfBatch> packagedItems) {
        this.description = description;
        this.packagedItems = packagedItems;
    }

    // Считает суммарный вес всех упакованных продуктов
    public double getTotalWeight() {
        return packagedItems.stream()//преобразует список в поток
                .mapToDouble(ProductOfBatch::getGrossWeight)//преобразует в тип даубле
                .sum();//суммирует значения
    }

    public List<ProductOfBatch> getPackagedItems() {
        return packagedItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductBatch that = (ProductBatch) o;
        return Objects.equals(description, that.description) &&
                Objects.equals(packagedItems, that.packagedItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, packagedItems);
    }

    @Override
    public String toString() {
        return "ProductBatch{" +
                "description='" + description + '\'' +
                ", packagedItems=" + packagedItems +
                '}';
    }
}