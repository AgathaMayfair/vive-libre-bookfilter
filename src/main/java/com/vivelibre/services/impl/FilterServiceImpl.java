package com.vivelibre.services.impl;

import com.vivelibre.dtos.Book;
import com.vivelibre.dtos.BookDate;
import com.vivelibre.services.FilterService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FilterServiceImpl implements FilterService {
    List<Book> books;

    @Override
    public Optional<BookDate> filter(String filter, List<Book> books) {
        this.books = books;
        printBooksWithoutPublicationTimestamp();
        List<Book> filteredBooks = findBooksBy(filter);
        if (filteredBooks.isEmpty()) {
            return Optional.empty();
        }
        Book mostRecentBook = getMostRecentBook(filteredBooks);
        BookDate bookDate = new BookDate(mostRecentBook, mostRecentBook.getPublicationTimestamp());
        sortList();
        return Optional.of(bookDate);
    }

    private void printBooksWithoutPublicationTimestamp(){
        books.stream()
                .filter(book -> (book.getPublicationTimestamp() == null || book.getPublicationTimestamp().isEmpty()))
                .forEach(book -> System.out.println("No Publication Timestamp: " + book.getTitle()));
    }

    private List<Book> findBooksBy(String filter){
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(filter.toLowerCase()) ||
                        book.getSummary().toLowerCase().contains(filter.toLowerCase()) ||
                        book.getAuthor().getBio().toLowerCase().contains(filter.toLowerCase()))
                .toList();
    }

    private Book getMostRecentBook(List<Book> filteredBooks){
        return filteredBooks.stream()
                .filter(book -> book.getPublicationTimestamp() != null && !book.getPublicationTimestamp().isEmpty())
                .max(Comparator.comparing(book -> Long.valueOf(book.getPublicationTimestamp())))
                .orElse(filteredBooks.get(0));
    }

    private void sortList(){
        books.sort(Comparator.comparing((Book book) -> {
                    String timestamp = book.getPublicationTimestamp();
                    return timestamp == null ? Long.MIN_VALUE : Long.parseLong(timestamp);
                }).reversed()
                .thenComparing(book -> book.getAuthor().getBio().length()));
    }
}
