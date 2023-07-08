package com.agussuhardi.wallet.controller;

import com.agussuhardi.library.config.GlobalApiResponse;
import com.agussuhardi.wallet.service.WalletCreditService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/wallet")
@Validated
@Slf4j
public class WalletCreditController {


    private final WalletCreditService walletCreditService;

    @GetMapping
    public ResponseEntity<?> getMyCredit() {
        return new GlobalApiResponse<>(walletCreditService.getByUser("UserInfo.getId"), HttpStatus.OK);
    }
}
