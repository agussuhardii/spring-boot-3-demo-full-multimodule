package com.agussuhardi.wallet.service.impl;

import com.agussuhardi.wallet.dto.WalletCreditDTO;
import com.agussuhardi.wallet.entity.WalletAdjust;
import com.agussuhardi.wallet.entity.WalletCredit;
import com.agussuhardi.wallet.entity.enumeric.WalletAdjustStatus;
import com.agussuhardi.wallet.repository.WalletCreditRepository;
import com.agussuhardi.wallet.service.WalletCreditService;
import com.agussuhardi.wallet.vo.WalletCreditQueryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class WalletCreditServiceImpl implements WalletCreditService {

    private final WalletCreditRepository walletCreditRepository;

    @Override
    @Transactional(isolation= Isolation.REPEATABLE_READ)
    public void addByAdmin(WalletAdjust adjust) {
        if (adjust.getStatus() != WalletAdjustStatus.SUCCESS) return;
        var wallet = walletCreditRepository.findById(adjust.getId()).orElse(
                WalletCredit.builder()
                        .credit(BigDecimal.ZERO)
                        .build()
        );
        wallet.setCredit(wallet.getCredit().add(adjust.getAdjust()));
        walletCreditRepository.save(wallet);
    }

    @Override
    public WalletCreditDTO getByUser(String userId) {
        WalletCredit original = walletCreditRepository.findById(userId)
                .orElse(WalletCredit.builder().userId(userId).credit(BigDecimal.ZERO).build());
        return toDTO(original);
    }

    @Override
    public Page<WalletCreditDTO> queryByAdmin(WalletCreditQueryVO vO, Pageable pageable) {
        return walletCreditRepository.findAll(pageable).map(this::toDTO);
    }

    private WalletCreditDTO toDTO(WalletCredit original) {
        WalletCreditDTO bean = new WalletCreditDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }
}
