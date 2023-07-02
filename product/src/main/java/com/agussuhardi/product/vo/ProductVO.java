package com.agussuhardi.product.vo;

import com.agussuhardi.product.validation.CategoryValidate;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;


public record ProductVO(

        @NotNull(message = "name can not null")
        String name,

        String text,

        String image,
        Long qty,
        @NotNull(message = "category can not null")
        @CategoryValidate
        String categoryId
) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


}
