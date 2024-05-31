package com.jeevankumar.spring_boot_validations.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BookResponse {
   private Integer id;
   private String title;
   private String language;
   private Integer yearOfPublication;
   private String authors;
}
