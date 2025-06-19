package org.skypro.skyshop.search;

import org.skypro.skyshop.articles.Searchable;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.*;

public class SearchEngine {
    private final Set<Searchable> searchables = new HashSet<>();

    public void add(Searchable searchable) {
        if (searchable != null) {
            searchables.add(searchable);
        }
    }

    public Set<Searchable> search(String query) {
        if (query == null || query.isBlank()) {
            return Collections.emptySortedSet();
        }

        String lowerQuery = query.toLowerCase();

        Comparator<Searchable> lengthThenNaturalComparator = Comparator
                .comparingInt((Searchable s) -> s.getName().length())
                .reversed()
                .thenComparing(Searchable::getName);

        return searchables.stream()
                .filter(item -> item.getSearchTerm().toLowerCase().contains(lowerQuery))
                .collect(Collectors.toCollection(() -> new TreeSet<>(lengthThenNaturalComparator)));
    }
}