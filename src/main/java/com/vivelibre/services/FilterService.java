package com.vivelibre.services;

import com.vivelibre.dtos.Book;
import com.vivelibre.dtos.BookDate;

import java.util.List;
import java.util.Optional;

public interface FilterService {

    Optional<BookDate> filter(String filter, List<Book> books);
}
