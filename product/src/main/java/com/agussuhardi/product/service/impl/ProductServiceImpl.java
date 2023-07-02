package com.agussuhardi.product.service.impl;


import com.agussuhardi.library.dto.CreateDTO;
import com.agussuhardi.product.dto.ProductDTO;
import com.agussuhardi.product.entity.Category;
import com.agussuhardi.product.entity.Product;
import com.agussuhardi.product.repository.ProductRepository;
import com.agussuhardi.product.service.ProductService;
import com.agussuhardi.product.vo.ProductQueryVO;
import com.agussuhardi.product.vo.ProductUpdateQtyVO;
import com.agussuhardi.product.vo.ProductUpdateVO;
import com.agussuhardi.product.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    @Override
    public CreateDTO add(ProductVO vO) {
        var category = Category.builder().id(vO.categoryId()).build();

        Product bean = new Product();
        BeanUtils.copyProperties(vO, bean);
        bean.setCategory(category);
        bean = productRepository.save(bean);
        return new CreateDTO(bean.getId());
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public void update(String id, ProductUpdateVO vO) {
        Product bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean, Product.Fields.qty);
        productRepository.save(bean);
    }

    @Override
    public void updateQty(String id, ProductUpdateQtyVO vo) {
        var bean = this.requireOne(id);
        bean.setQty(vo.qty());
        productRepository.save(bean);
    }

    @Override
    public ProductDTO getById(String id) {
        Product original = requireOne(id);
        return toDTO(original);
    }

    @Override
    public Page<ProductDTO> query(ProductQueryVO vO, Pageable pageable) {
        return productRepository.findAll(pageable).map(this::toDTO);
    }

    private ProductDTO toDTO(Product original) {
        ProductDTO bean = new ProductDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    @Override
    public Product requireOne(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
