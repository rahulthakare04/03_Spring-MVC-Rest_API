package com.example.springboottwebutorial.dto;

import com.example.springboottwebutorial.annotations.PasswordValidation;
import com.example.springboottwebutorial.annotations.PrimeNumberValidation;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {


    private Long id;

    @NotBlank(message = "title must not be empty")
    private String title;

    @AssertTrue(message = "always need true")
    private Boolean isActive;

    @PastOrPresent(message = "date must be in past or present ")
    private LocalDate createAt;

    @PrimeNumberValidation
    private Integer number;

    @PasswordValidation
    private String password;

}
