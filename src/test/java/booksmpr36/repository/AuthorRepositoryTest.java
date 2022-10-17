package booksmpr36.repository;

import model.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.AuthorRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AuthorRepositoryTest {

    AuthorRepository authorRepository;

    @BeforeEach
    void setUp() {
        authorRepository = new AuthorRepository();
    }

    @Test
    void Should_CreateAuthorWithCorrectInput() {
        //given
        Author a = new Author();
        //when
        authorRepository.creatAuthor(a);
        //then
        assertNotNull(a.getId());
    }

    @Test
    void Should_GetAllAuthors() {
        //give
        List<Author> authors;
        //when
        authors = authorRepository.getAllAuthors();
        //then
        assertNotNull(authors);
    }

    @Test
    void Should_deleteAuthorWithCorrectInput() {
        //given
        authorRepository.creatAuthor(new Author());
        authorRepository.creatAuthor(new Author());
        authorRepository.creatAuthor(new Author());
        //when
        authorRepository.deleteAuthor(0L);
        //then
        assertEquals(2, authorRepository.getAllAuthors().size());
    }

    @Test
    void Should_getAuthorByIdWithProperInput() {
        //given
        authorRepository.creatAuthor(new Author());
        //when
        Author a = authorRepository.getAuthorById(0L);
        //then
        assertNotNull(a);
    }

    @Test
    void Should_throwIllegalArgumentExceptionWhenGettingAuthorWhichNotExist() {
        //given
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> authorRepository.getAuthorById(0L));
    }
}