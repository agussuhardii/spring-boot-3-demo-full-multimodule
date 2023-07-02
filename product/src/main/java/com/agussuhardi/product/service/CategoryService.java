package com.agussuhardi.product.service;


import com.agussuhardi.library.dto.CreateDTO;
import com.agussuhardi.product.dto.CategoryDTO;
import com.agussuhardi.product.vo.CategoryQueryVO;
import com.agussuhardi.product.vo.CategoryVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CategoryService {
    CreateDTO add(CategoryVO vO);

    void delete(String id);

    void update(String id, CategoryVO vO);

    CategoryDTO getById(String id);

    Page<CategoryDTO> query(CategoryQueryVO vO, Pageable pageable);
}
