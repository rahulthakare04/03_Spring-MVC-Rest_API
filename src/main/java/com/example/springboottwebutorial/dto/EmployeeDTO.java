package com.example.springboottwebutorial.dto;

import com.example.springboottwebutorial.annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "required field name must not be empty ")
    @Size(min = 3, max = 10, message = "name must be in the range of [3,10]")
    private String name;

    @Email(message = "email should be valid email")
    private String email;

    @Max(value = 80, message = "the employee age must not be greter than 80")
    @Min(value = 18, message = "the employee age must not be smaller than 18")
    private Integer age;

    @PastOrPresent(message = "date of joining must be past or present ")
    private LocalDate dateOfJouning;
    private Boolean isActive;

    @NotNull(message = "salary of employee not be null")
    @Positive(message = "salary of employee must be positive ")
    private Integer salary;

    //@Pattern(regexp = "^(ADMIN|USER)$")
    @EmployeeRoleValidation
    @NotBlank(message = "roel of employee not be null")
    private String role;//ADMIN|USER


}