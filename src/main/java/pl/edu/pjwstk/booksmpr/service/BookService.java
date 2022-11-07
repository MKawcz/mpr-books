package pl.edu.pjwstk.booksmpr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.booksmpr.model.Book;
import pl.edu.pjwstk.booksmpr.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book) {
        return bookRepository.createBook(book);
    }

    public List<Book> getBooks(){
        return bookRepository.getAllBooks();
    }

    public Book getBookById(Long id){
        return bookRepository.getBookById(id);
    }

    public Book updateBook(Long id, Book book){
        return bookRepository.updateBook(id, book);
    }

    public void deleteBookById(Long id){
        bookRepository.deleteBook(id);
    }
}
