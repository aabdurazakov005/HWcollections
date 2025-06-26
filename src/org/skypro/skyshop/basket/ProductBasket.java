package org.skypro.skyshop.basket;


import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProductBasket {
    private final Map<String, List<Product>> productsMap = new HashMap<>();

    public void addProduct(Product product) {
        productsMap.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public List<Product> removeProductsByName(String name) {
        return productsMap.remove(name.toLowerCase());
    }

    public int getTotalPrice() {
        return productsMap.values().stream()
                .flatMap(List::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printBasketContents() {
        if (productsMap.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }

        productsMap.forEach((name, products) ->
                products.forEach(product ->
                        System.out.println(product.getName() + ": " + product.getPrice())
                )
        );
        System.out.println("Итого: " + getTotalPrice());
    }

    public boolean containsProduct(String productName) {
        return productsMap.containsKey(productName.toLowerCase());
    }

    public void clearBasket() {
        productsMap.clear();
    }
}