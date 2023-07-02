package com.agussuhardi.product.service;

import com.agussuhardi.library.dto.CreateDTO;
import com.agussuhardi.product.dto.ProductDTO;
import com.agussuhardi.product.entity.Product;
import com.agussuhardi.product.vo.ProductQueryVO;
import com.agussuhardi.product.vo.ProductUpdateQtyVO;
import com.agussuhardi.product.vo.ProductUpdateVO;
import com.agussuhardi.product.vo.ProductVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    CreateDTO add(ProductVO vO);

    void delete(String id);

    void update(String id, ProductUpdateVO vO);

    void updateQty(String id, ProductUpdateQtyVO vo);

    ProductDTO getById(String id);

    Page<ProductDTO> query(ProductQueryVO vO, Pageable pageable);

    Product requireOne(String id);
}
