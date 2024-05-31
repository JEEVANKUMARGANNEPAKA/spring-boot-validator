package com.jeevankumar.spring_boot_validations.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "BOOKS")

public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String language;
    private Integer yearOfPublication;
    private String authors;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "REVIEWS",joinColumns = @JoinColumn(name = "BOOK_ID"))
    @Column(name = "TEXT")
    private List<String> reviews = new ArrayList<>();
}
