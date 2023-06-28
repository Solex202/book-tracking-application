package com.lotaproject.bookTracking.service;

import com.lotaproject.bookTracking.dto.UpdateAuthorDto;
import com.lotaproject.bookTracking.exception.BookApplicationException;
import com.lotaproject.bookTracking.model.Author;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
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
        author.setName("esther");

        authorService.addAuthor(author);
    }

    @Test
    void testThatCanFindAuthorByName(){

        Author author = new Author();
        author.setName("esther");

        authorService.addAuthor(author);

        Author newAuthor = authorService.findByName("esther");

        assertAll(
                ()-> assertEquals("esther", newAuthor.getName()),
                ()-> assertNotNull(newAuthor)

        );
    }

    @Test
    void testThatCanFindAuthorByName_throwException(){

        Author author = new Author();
        author.setName("esther");

        authorService.addAuthor(author);

        assertThrows(BookApplicationException.class, ()->authorService.findByName("we"));

    }

    @Test
    void testThatCanUpdateAuthor(){

        Author author = new Author();
        author.setName("juju");
        author.setId(7L);

        authorService.addAuthor(author);

        UpdateAuthorDto dto = new UpdateAuthorDto();
        dto.setName("uwa");

        String update = authorService.updateAuthor(author.getId(), dto);
        assertAll(
                ()->assertThat(author.getName(), is("uwa")),
//                ()-> assertEquals("deji", author.getName()),
                ()-> assertEquals("Author updated", update)

        );
    }

    @AfterEach
    void tearDown() {
    }
}