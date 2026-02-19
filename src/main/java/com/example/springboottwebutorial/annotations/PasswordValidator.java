package com.example.springboottwebutorial.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;


public class PasswordValidator implements ConstraintValidator<PasswordValidation,String> {
    private static final String regPass= "^(?=.*[A-Z])(?=.*[a-z])(?=.*[^A-Za-z0-9]).{10,}$";
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

      if(s.isBlank()) return false;
      return Pattern.matches(regPass, s);
    }
}
