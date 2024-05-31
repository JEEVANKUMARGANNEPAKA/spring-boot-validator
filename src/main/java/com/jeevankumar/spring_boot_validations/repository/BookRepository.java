package com.jeevankumar.spring_boot_validations.repository;

import com.jeevankumar.spring_boot_validations.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Integer> {
    Optional<BookEntity> findByTitle(String title);
}
