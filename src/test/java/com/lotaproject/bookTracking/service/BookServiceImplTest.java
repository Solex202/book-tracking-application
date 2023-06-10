package com.lotaproject.bookTracking.service;

import com.lotaproject.bookTracking.model.Book;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor
class BookServiceImplTest {

    private final BookService bookService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testThatCanAddBooksToDatabase(){
       List<Book> books = bookService.addBookToDatabase();

    }

    @AfterEach
    void tearDown() {
    }
}