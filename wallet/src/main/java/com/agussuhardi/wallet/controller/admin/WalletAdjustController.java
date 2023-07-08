package com.agussuhardi.wallet.controller.admin;

import com.agussuhardi.library.config.GlobalApiResponse;
import com.agussuhardi.wallet.service.WalletAdjustAdminService;
import com.agussuhardi.wallet.vo.WalletAdjustQueryVO;
import com.agussuhardi.wallet.vo.WalletAdjustVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/admin/wallet/adjust")
@Validated
@Slf4j
public class WalletAdjustController {


    private final WalletAdjustAdminService walletAdjustAdminService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid WalletAdjustVO vo) {
        return new GlobalApiResponse<>(walletAdjustAdminService.add(vo), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@Valid @NotNull @PathVariable("id") String id) {
        return new GlobalApiResponse<>(walletAdjustAdminService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> query(@Valid WalletAdjustQueryVO vO, Pageable pageable) {
        return new GlobalApiResponse<>(walletAdjustAdminService.query(vO, pageable), HttpStatus.OK);
    }
}
