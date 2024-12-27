package org.example;

import java.util.Objects;

// Класс для упакованного весового товара
public class PackagedWeightedProduct extends WeightedProduct implements ProductOfBatch {
    private Packaging packaging;
    private double weight;

    public PackagedWeightedProduct(String name, String description, double weight, Packaging packaging) {
        super(name, description);
        this.weight = weight;
        this.packaging = packaging;
    }

    // Масса товара без упаковки
    public double getNetWeight() {
        return weight;
    }

    // Масса товара с упаковкой
    @Override
    public double getGrossWeight() {
        return weight + packaging.getWeight();
    }

    // Получаем упаковку
    @Override
    public Packaging getPackaging() {
        return packaging;
    }

    // Переопределение equals для правильного сравнения объектов
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PackagedWeightedProduct that = (PackagedWeightedProduct) o;
        return Double.compare(that.weight, weight) == 0 && Objects.equals(packaging, that.packaging);
    }

    // Переопределение hashCode для корректной работы коллекций
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), packaging, weight);
    }

    // Переопределение toString для удобства вывода
    @Override
    public String toString() {
        return "PackagedWeightedProduct{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", netWeight=" + getNetWeight() +
                ", grossWeight=" + getGrossWeight() +
                ", packaging=" + packaging +
                '}';
    }
}
