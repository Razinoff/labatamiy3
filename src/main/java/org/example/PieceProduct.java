package org.example;

import java.util.Objects;

public class PieceProduct extends Product {
    private double weightPerPiece;

    public PieceProduct(String name, String description, double weightPerPiece) {
        super(name, description);//вызывает конструктор
        //вроде как может вызывать методы super.getDescription()
        this.weightPerPiece = weightPerPiece;
    }

    public double getWeightPerPiece() {
        return weightPerPiece;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        PieceProduct that = (PieceProduct) o;
        return Double.compare(that.weightPerPiece, weightPerPiece) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weightPerPiece);
    }

    @Override
    public String toString() {
        return "PieceProduct{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", weightPerPiece=" + weightPerPiece +
                '}';
    }
}