package org.skypro.skyshop.product;

public class  DiscountedProduct extends Product {
    private final int basePrice;
    private final int discount;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        if (basePrice <= 0) {
            throw new IllegalArgumentException(
                    "Базовая цена продукта должна быть строго больше 0 (передано: " + basePrice + ")");
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException(
                    "Процент скидки должен быть в диапазоне от 0 до 100 включительно (передано: " + discount + ")");
        }
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return basePrice * (100 - discount) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discount + "%)";
    }
}