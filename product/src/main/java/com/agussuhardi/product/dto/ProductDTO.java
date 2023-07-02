package com.agussuhardi.product.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;

    private String name;

    private String text;

    private String image;

}
