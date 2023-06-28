package com.lotaproject.bookTracking.service;

import com.lotaproject.bookTracking.dto.AddBookDto;
import com.lotaproject.bookTracking.exception.BookApplicationException;
import com.lotaproject.bookTracking.model.Author;
import com.lotaproject.bookTracking.model.Book;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
@RequiredArgsConstructor
@SpringBootTest
class BookServiceImplTest {






    @Autowired
    private  BookService bookService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testThatCanAddBooksToDatabase(){
       List<AddBookDto> books = new ArrayList<>();

       List<String> authors = new ArrayList<>();

        String name1 = "lota";

       var author2 = new Author();
       author2.setName("deola");

       authors.add(name1);

       var book1 = new AddBookDto();
       book1.setAuthors(authors);
       book1.setCover_image("image");
       book1.setPublishedDate("03-03-2034");
       book1.setIsbn("9999999999999");
       book1.setDescription("fiction");
       book1.setTitle("juju");
       book1.setLatestRevision("2018");

       books.add(book1);

        var book2 = new AddBookDto();
        book2.setAuthors(authors);
        book2.setCover_image("image");
        book2.setPublishedDate("03-03-2034");
        book2.setIsbn("6666666666666");
        book2.setDescription("romance");
        book2.setTitle("my love");
        book2.setLatestRevision("2018");

        books.add(book2);

         bookService.addBookToDatabase(books);

    }

    @Test
    void testThatCannotAddBooksToDatabase_if_isbnIsInvalid(){
        List<AddBookDto> books = new ArrayList<>();

        List<String> authors = new ArrayList<>();

        String name1 = "lota";

        authors.add(name1);

        var book1 = new AddBookDto();
        book1.setAuthors(authors);
        book1.setCover_image("image");
        book1.setPublishedDate("03-03-2034");
        book1.setIsbn("999999999");
        book1.setDescription("fiction");
        book1.setTitle("juju");
        book1.setLatestRevision("2018");

        books.add(book1);

        assertThrows(BookApplicationException.class, ()-> bookService.addBookToDatabase(books));

    }

    @Test
    void testThatCanFindBookByIsbn(){

        List<AddBookDto> books = new ArrayList<>();

        List<String> authors = new ArrayList<>();

        String name1 = "lota";

        authors.add(name1);
        var book2 = new AddBookDto();
        book2.setAuthors(authors);
        book2.setCover_image("image");
        book2.setPublishedDate("03-03-2034");
        book2.setIsbn("6666666666666");
        book2.setDescription("romance");
        book2.setTitle("my love");
        book2.setLatestRevision("2018");

        books.add(book2);

        bookService.addBookToDatabase(books);
        Book book = bookService.findByIsbn("6666666666666");
        assertAll(
                ()-> assertNotNull(book),
                ()-> assertEquals("my love", book.getTitle())

        );

    }

    @Test
    void testThatCannotFindBookByInvalidIsbn_throwException(){

        assertThrows(BookApplicationException.class, ()->bookService.findByIsbn("666666"));
    }

    @Test
    void testThatCanFindBookByTitle(){

        List<AddBookDto> books = new ArrayList<>();

        List<String> authors = new ArrayList<>();

        String name1 = "lota";

        authors.add(name1);
        var book2 = new AddBookDto();
        book2.setAuthors(authors);
        book2.setCover_image("image");
        book2.setPublishedDate("03-03-2034");
        book2.setIsbn("6666666666666");
        book2.setDescription("romance");
        book2.setTitle("my love");
        book2.setLatestRevision("2018");

        books.add(book2);

        bookService.addBookToDatabase(books);
        Book book = bookService.findByTitle("my lovenn");
        assertAll(
                ()-> assertNotNull(book),
                ()-> assertEquals("my love", book.getTitle()),
                ()-> assertEquals("romance", book.getDescription())

        );

    }

    @Test
    void testThatCannotFindBookByIncorrectTitle_throwException(){

        assertThrows(BookApplicationException.class, ()->bookService.findByTitle("incorrect"));
    }

    @AfterEach
    void tearDown() {
    }
}