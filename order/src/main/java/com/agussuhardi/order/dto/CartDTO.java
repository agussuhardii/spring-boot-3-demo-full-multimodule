package com.agussuhardi.order.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class CartDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;

    private String userId;

}
