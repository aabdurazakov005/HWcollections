package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.articles.Searchable;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        SearchEngine engine = new SearchEngine();

        engine.add(new SimpleProduct("Молоко", 80));
        engine.add(new Article("Польза молочных продуктов", "Текст статьи..."));
        engine.add(new SimpleProduct("Хлеб", 50));
        engine.add(new Article("Рецепты хлеба", "Текст статьи..."));
        engine.add(new SimpleProduct("Йогурт", 60));
        engine.add(new Article("Молоко и здоровье", "Текст статьи..."));

        System.out.println("Результаты поиска 'молоко':");
        Set<Searchable> results = engine.search("молоко");
        results.forEach(item -> System.out.println(
                item.getName() + " (" + item.getContentType() + ")"
        ));
    }
}