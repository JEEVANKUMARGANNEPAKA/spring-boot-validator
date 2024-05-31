package com.jeevankumar.spring_boot_validations.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewRequest {
    @NotEmpty(message = "{required.field}")
    @Size(min = 1, max = 200, message = "{invalid.field}")
    private String review;
}
