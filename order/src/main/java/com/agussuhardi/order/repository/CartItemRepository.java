package com.agussuhardi.order.repository;


import com.agussuhardi.order.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CartItemRepository extends JpaRepository<CartItem, String>, JpaSpecificationExecutor<CartItem> {

}