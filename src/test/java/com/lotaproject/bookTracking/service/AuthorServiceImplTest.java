package com.lotaproject.bookTracking.service;

import com.lotaproject.bookTracking.model.Author;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor
class AuthorServiceImplTest {

    @Autowired
    private AuthorService authorService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void test_addAuthors(){

        Author author = new Author();
        author.setName("deola");

        authorService.addAuthor(author);
    }

    @AfterEach
    void tearDown() {
    }
}