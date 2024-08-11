package com.vivelibre;

import com.vivelibre.dtos.Book;
import com.vivelibre.dtos.BookDate;
import com.vivelibre.services.BooksRetrieverService;
import com.vivelibre.services.FilterService;
import com.vivelibre.services.impl.BooksRetrieverServiceImpl;
import com.vivelibre.services.impl.FilterServiceImpl;

import java.util.List;
import java.util.Optional;

public class Main {

    static FilterService filterService = new FilterServiceImpl();

    static BooksRetrieverService booksRetrieverService = new BooksRetrieverServiceImpl();

    public static void main(String[] args) {

        List<Book> books = booksRetrieverService.get();

        Optional<BookDate> result1 = filterService.filter("potter", books);

        System.out.println(result1.toString());

    }

}