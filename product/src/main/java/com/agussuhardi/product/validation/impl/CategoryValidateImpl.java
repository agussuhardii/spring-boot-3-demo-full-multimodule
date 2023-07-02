package com.agussuhardi.product.validation.impl;


import com.agussuhardi.product.repository.CategoryRepository;
import com.agussuhardi.product.validation.CategoryValidate;
import com.google.common.base.Strings;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


@RequiredArgsConstructor
public class CategoryValidateImpl implements ConstraintValidator<CategoryValidate, String> {

    @Autowired
    private final CategoryRepository categoryRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Strings.isNullOrEmpty(value)) return true;
        return categoryRepository.findById(value).isPresent();
    }
}
