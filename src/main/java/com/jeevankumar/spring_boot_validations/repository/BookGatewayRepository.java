package com.jeevankumar.spring_boot_validations.repository;

import com.jeevankumar.spring_boot_validations.entity.Book;
import com.jeevankumar.spring_boot_validations.entity.BookEntity;
import com.jeevankumar.spring_boot_validations.util.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class BookGatewayRepository {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public List<Book> findAllBooks(){
       List<BookEntity> bookEntities = this.bookRepository.findAll();
       return bookEntities.stream().map(bookMapper::toModel).collect(Collectors.toList());
    }
    public Optional<Book> findBookById(Integer bookId){
        Optional<BookEntity> bookEntity = this.bookRepository.findById(bookId);
        if (bookEntity.isEmpty())
            return Optional.empty();
        return Optional.of(bookMapper.toModel(bookEntity.get()));
    }
    public Book saveBook(Book book){
        BookEntity bookEntity = bookMapper.toEntity(book);
        bookEntity = bookRepository.save(bookEntity);
        return bookMapper.toModel(bookEntity);
    }
    public Book update(Book book) {
        BookEntity entityForUpdate = bookRepository.findById(book.getId()).get();
        BookEntity entityFromUpdatedModel = bookMapper.toEntity(book);
        bookMapper.copyValues(entityFromUpdatedModel, entityForUpdate);
        entityForUpdate = bookRepository.save(entityForUpdate);
        return bookMapper.toModel(entityForUpdate);
    }

    public void delete(Integer id) {
        BookEntity entity = bookRepository.findById(id).get();
        bookRepository.delete(entity);
    }

    public List<String> findReviewsOfBook(Integer bookId) {
        BookEntity bookEntity = bookRepository.findById(bookId).get();
        List<String> reviews = bookEntity.getReviews();
        if (reviews == null)
            return new ArrayList<>();
        return reviews;
    }

    public String addReview(Integer bookId, String review) {
        BookEntity bookEntity = bookRepository.findById(bookId).get();
        if (bookEntity.getReviews() == null)
            bookEntity.setReviews(new ArrayList<>());
        bookEntity.getReviews().add(review);
        bookRepository.save(bookEntity);
        return review;
    }
}
