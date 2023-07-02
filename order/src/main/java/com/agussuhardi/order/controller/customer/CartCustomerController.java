package com.agussuhardi.order.controller.customer;

import com.agussuhardi.library.config.GlobalApiResponse;
import com.agussuhardi.order.service.CartCustomerService;
import com.agussuhardi.order.vo.CartVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("customer/api/v1/carts")
@RequiredArgsConstructor
public class CartCustomerController {


    private final CartCustomerService cartService;

    @PostMapping
    public ResponseEntity<?> addItems(@Valid @RequestBody CartVO vO) {
        return new GlobalApiResponse<>(cartService.addItems(vO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getByPrincipal() {
        return new GlobalApiResponse<>(cartService.getByPrincipal(), HttpStatus.OK);
    }

}
