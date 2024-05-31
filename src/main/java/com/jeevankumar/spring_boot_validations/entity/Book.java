package com.jeevankumar.spring_boot_validations.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    private Integer id;
    private String title;
    private String language;
    private Integer yearOfPublication;
    private String authors;
}
