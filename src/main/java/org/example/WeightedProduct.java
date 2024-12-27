package org.example;

public class WeightedProduct extends Product {

    public WeightedProduct(String name, String description) {
        super(name, description);
    }

    @Override
    public String toString() {
        return "WeightedProduct" + super.toString().substring(7);  // Убираем "Product{"
    }


}
