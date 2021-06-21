package com.ass.mvc.services;
import java.util.List;
import java.util.Optional;

//...
import org.springframework.stereotype.Service;

import com.ass.mvc.models.Book;
import com.ass.mvc.repositories.BookRepository;
@Service
public class BookService {
 // adding the book repository as a dependency
private final BookRepository bookRepository;
 
 public BookService(BookRepository bookRepository) {
     this.bookRepository = bookRepository;
 }
 // returns all the books
 public List<Book> allBooks() {
     return bookRepository.findAll();
 }
 // creates a book
 public Book createBook(Book b) {
     return bookRepository.save(b);
 }
 // retrieves a book
 public Book findBook(Long id) {
     Optional<Book> optionalBook = bookRepository.findById(id);
     if(optionalBook.isPresent()) {
         return optionalBook.get();
     } else {
         return null;
     }
 }
 public Book updateBook(Book book) {
    
   
    		return bookRepository.save(book);

 }
 
 public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
     Optional<Book> optionalBook = bookRepository.findById(id);
if (optionalBook.isPresent()) {
	Book update=optionalBook.get();
	update.setTitle(title);
	update.setDescription(desc);
	update.setLanguage(lang);
	update.setNumberOfPages(numOfPages);
return bookRepository.save(update);}
else {
	return null;
}
 }
 
 public void deleteBook(Long id) {
   bookRepository.deleteById(id);
}
 

  
 
}


