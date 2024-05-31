package com.jeevankumar.spring_boot_validations.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    @NotEmpty(message = "{required.field}")
    @Size(min = 1,max = 200,message = "{invalid.field}")
    private String title;

    @NotEmpty(message = "{required.field}")
    @Size(min = 1,max = 50,message = "{invalid.field}")
    private String language;

    @PositiveOrZero(message = "{invalid.field}")
    private Integer yearOfPublication;

    @Size(min = 1,max = 200,message = "{invalid.field}")
    private String authors;
}
