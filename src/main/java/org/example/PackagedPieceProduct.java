package org.example;

import java.util.Objects;

// Класс для упакованного штучного товара
public class PackagedPieceProduct extends PieceProduct implements ProductOfBatch {
    private Packaging packaging;
    private int quantity;

    public PackagedPieceProduct(String name, String description, double weightPerPiece, int quantity, Packaging packaging) {
        super(name, description, weightPerPiece);
        this.quantity = quantity;
        this.packaging = packaging;
    }

    public int getQuantity() {
        return quantity; // Количество штук
    }

    public Packaging getPackaging() {
        return packaging;
    }

    public double getNetWeight() {
        return getQuantity() * getWeightPerPiece(); // Масса всех единиц товара
    }

    @Override
    public double getGrossWeight() {
        return getNetWeight() + packaging.getWeight(); // Масса всех товаров + упаковка
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PackagedPieceProduct that = (PackagedPieceProduct) o;
        return quantity == that.quantity && Objects.equals(packaging, that.packaging);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), packaging, quantity);
    }

    @Override
    public String toString() {
        return "PackagedPieceProduct{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", weightPerPiece=" + getWeightPerPiece() +
                ", quantity=" + quantity +
                ", packaging=" + packaging +
                '}';
    }
}
