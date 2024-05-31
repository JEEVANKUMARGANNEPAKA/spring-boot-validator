package com.jeevankumar.spring_boot_validations.service;

import com.jeevankumar.spring_boot_validations.entity.Book;
import com.jeevankumar.spring_boot_validations.exception.ResourceAlreadyExistException;
import com.jeevankumar.spring_boot_validations.exception.ResourceNotFoundException;
import com.jeevankumar.spring_boot_validations.repository.BookGatewayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookGatewayRepository booksRepo;


    public List<Book> findBooks() {
        return booksRepo.findAllBooks();
    }

    public Book findBookById(Integer id) {
        return booksRepo.findBookById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Book.class.getSimpleName(), id));
    }

    public Book createBook(Book book) {
        Optional<Book> registeredBook = booksRepo.findBookById(book.getId());
        if (registeredBook.isPresent())
            throw new ResourceAlreadyExistException(Book.class.getSimpleName(), registeredBook.get().getId());
        return booksRepo.saveBook(book);
    }

    public Book updateBook(Book book) {
        abortIfBookDoesNotExist(book.getId());
        Book updated = booksRepo.update(book);
        return updated;
    }

    public void deleteBook(Integer id) {
        abortIfBookDoesNotExist(id);
        booksRepo.delete(id);
    }

    public List<String> findReviews(Integer bookId) {
        abortIfBookDoesNotExist(bookId);
        return booksRepo.findReviewsOfBook(bookId);
    }

    public String addReview(Integer bookId, String review) {
        abortIfBookDoesNotExist(bookId);
        return booksRepo.addReview(bookId, review);
    }


    private void abortIfBookDoesNotExist(Integer id) {
        booksRepo.findBookById(id).orElseThrow(() -> new ResourceNotFoundException(Book.class.getSimpleName(), id));
    }
}
