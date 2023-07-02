package com.agussuhardi.order.service;


import com.agussuhardi.library.dto.CreateDTO;
import com.agussuhardi.order.dto.CartDTO;
import com.agussuhardi.order.vo.CartVO;

/**
 * @author agussuhardi
 * @created 28/06/23/06/2023 :19.14
 * @project spring-demo-full
 */
public interface CartCustomerService {
    CreateDTO addItems(CartVO vo);

    CartDTO getByPrincipal();
}
