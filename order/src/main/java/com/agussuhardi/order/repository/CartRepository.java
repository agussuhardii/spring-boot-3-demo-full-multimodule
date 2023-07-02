package com.agussuhardi.order.repository;


import com.agussuhardi.order.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, String>, JpaSpecificationExecutor<Cart> {

    Optional<Cart> findByUserId(String userId);
}