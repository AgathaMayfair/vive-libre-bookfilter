package com.vivelibre.services.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vivelibre.Main;
import com.vivelibre.dtos.Book;
import com.vivelibre.services.BooksRetrieverService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BooksRetrieverServiceImpl implements BooksRetrieverService {

    @Override
    public List<Book> get() {

        ObjectMapper objectMapper = new ObjectMapper();

        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("books.json")) {

            if (inputStream == null) {
                throw new IOException("Resource not found: books.json");
            }

            return objectMapper.readValue(inputStream, new TypeReference<>() {});

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
