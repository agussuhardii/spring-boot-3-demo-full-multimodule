package com.agussuhardi.product.service.impl;


import com.agussuhardi.library.dto.CreateDTO;
import com.agussuhardi.product.dto.CategoryDTO;
import com.agussuhardi.product.entity.Category;
import com.agussuhardi.product.repository.CategoryRepository;
import com.agussuhardi.product.service.CategoryService;
import com.agussuhardi.product.vo.CategoryQueryVO;
import com.agussuhardi.product.vo.CategoryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CreateDTO add(CategoryVO vO) {
        Category bean = new Category();
        BeanUtils.copyProperties(vO, bean);
        bean = categoryRepository.save(bean);
        return new CreateDTO(bean.getId());
    }

    @Override
    public void delete(String id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void update(String id, CategoryVO vO) {
        Category bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        categoryRepository.save(bean);
    }

    @Override
    public CategoryDTO getById(String id) {
        Category original = requireOne(id);
        return toDTO(original);
    }

    @Override
    public Page<CategoryDTO> query(CategoryQueryVO vO, Pageable pageable) {
        return categoryRepository.findAll(pageable).map(this::toDTO);
    }

    private CategoryDTO toDTO(Category original) {
        CategoryDTO bean = new CategoryDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Category requireOne(String id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
