package org.skypro.skyshop.articles;

import java.util.Objects;

public final class Article implements Searchable {
    private final String title;
    private final String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String getSearchTerm() {
        return toString(); // Для статей поиск по всему тексту
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public String toString() {
        return title + "\n" + content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return title.equalsIgnoreCase(article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title.toLowerCase());
    }
}