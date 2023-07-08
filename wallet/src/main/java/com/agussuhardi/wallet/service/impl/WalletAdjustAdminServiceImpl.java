package com.agussuhardi.wallet.service.impl;

import com.agussuhardi.library.dto.CreateDTO;
import com.agussuhardi.wallet.dto.WalletAdjustDTO;
import com.agussuhardi.wallet.entity.WalletAdjust;
import com.agussuhardi.wallet.entity.enumeric.WalletAdjustStatus;
import com.agussuhardi.wallet.repository.WalletAdjustRepository;
import com.agussuhardi.wallet.service.WalletAdjustAdminService;
import com.agussuhardi.wallet.service.WalletCreditService;
import com.agussuhardi.wallet.vo.WalletAdjustQueryVO;
import com.agussuhardi.wallet.vo.WalletAdjustVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class WalletAdjustAdminServiceImpl implements WalletAdjustAdminService {

    private final WalletAdjustRepository walletAdjustRepository;
    private final WalletCreditService walletCreditService;

    @Override
    @Transactional(isolation= Isolation.REPEATABLE_READ)
    public CreateDTO add(WalletAdjustVO vO) {
        var adjust = new WalletAdjust();
        BeanUtils.copyProperties(vO, adjust);
        adjust.setStatus(WalletAdjustStatus.SUCCESS);
        adjust = walletAdjustRepository.save(adjust);
        this.walletCreditService.addByAdmin(adjust);
        return new CreateDTO(adjust.getId());
    }

    @Override
    public WalletAdjustDTO getById(String id) {
        WalletAdjust original = requireOne(id);
        return toDTO(original);
    }

    @Override
    public Page<WalletAdjustDTO> query(WalletAdjustQueryVO vO, Pageable pageable) {
//        Slice<?> e = walletAdjustRepository.findAll(pageable);
        return walletAdjustRepository.findAll(pageable).map(this::toDTO);
    }

    private WalletAdjustDTO toDTO(WalletAdjust original) {
        WalletAdjustDTO bean = new WalletAdjustDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private WalletAdjust requireOne(String id) {
        return walletAdjustRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
