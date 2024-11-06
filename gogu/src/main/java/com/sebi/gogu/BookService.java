package com.sebi.gogu;

import com.sebi.gogu.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(BookService.class);
    public List<Book> findAllBooks(){return bookRepository.findAll();}

    public Book findBookById(Long id){
        LOGGER.info("findbook {}",id);
        
        Book book;

    book = bookRepository.findById(id).orElseThrow(()->new RuntimeException("Book not found"));
    return book;}

    public void createBook(Book book)
    {bookRepository.save(book);}

    public void deleteBook(Long id)
    {
       Book book = bookRepository.findById(id).orElseThrow(()->new RuntimeException("Book not found"));
       bookRepository.deleteById(book.getId());
    }
}
