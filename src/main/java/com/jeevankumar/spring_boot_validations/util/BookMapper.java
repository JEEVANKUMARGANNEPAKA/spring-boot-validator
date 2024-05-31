package com.jeevankumar.spring_boot_validations.util;

import com.jeevankumar.spring_boot_validations.dto.BookRequest;
import com.jeevankumar.spring_boot_validations.dto.BookResponse;
import com.jeevankumar.spring_boot_validations.entity.Book;
import com.jeevankumar.spring_boot_validations.entity.BookEntity;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookMapper {

    private final ModelMapper modelMapper;

    public Book toModel(BookEntity bookEntity){
        return modelMapper.map(bookEntity,Book.class);
    }
    public BookEntity toEntity(Book book){
        return modelMapper.map(book,BookEntity.class);
    }
    public BookEntity copyValues(BookEntity source, BookEntity destination){
        modelMapper.map(source,destination);
        return destination;
    }
    public Book toModel(BookRequest bookRequest){
        return modelMapper.map(bookRequest,Book.class);
    }
    public BookRequest toRequest(Book book){
        return modelMapper.map(book,BookRequest.class);
    }
    public BookResponse toResponse(Book book){
        return modelMapper.map(book,BookResponse.class);
    }
}
