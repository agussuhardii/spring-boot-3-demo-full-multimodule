package com.agussuhardi.wallet.service.impl;

import com.agussuhardi.library.dto.CreateDTO;
import com.agussuhardi.wallet.dto.WalletWalletAdjustDTO;
import com.agussuhardi.wallet.entity.WalletAdjust;
import com.agussuhardi.wallet.entity.enumeric.WalletAdjustStatus;
import com.agussuhardi.wallet.repository.WalletAdjustRepository;
import com.agussuhardi.wallet.service.WalletAdjustAdminService;
import com.agussuhardi.wallet.service.WalletCreditService;
import com.agussuhardi.wallet.vo.WalletWalletAdjustQueryVO;
import com.agussuhardi.wallet.vo.WalletWalletAdjustVO;
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
    public CreateDTO add(WalletWalletAdjustVO vO) {
        var adjust = new WalletAdjust();
        BeanUtils.copyProperties(vO, adjust);
        adjust.setStatus(WalletAdjustStatus.SUCCESS);
        adjust = walletAdjustRepository.save(adjust);
        this.walletCreditService.addByAdmin(adjust);
        return new CreateDTO(adjust.getId());
    }

    @Override
    public WalletWalletAdjustDTO getById(String id) {
        WalletAdjust original = requireOne(id);
        return toDTO(original);
    }

    @Override
    public Page<WalletWalletAdjustDTO> query(WalletWalletAdjustQueryVO vO, Pageable pageable) {
//        Slice<?> e = walletAdjustRepository.findAll(pageable);
        return walletAdjustRepository.findAll(pageable).map(this::toDTO);
    }

    private WalletWalletAdjustDTO toDTO(WalletAdjust original) {
        WalletWalletAdjustDTO bean = new WalletWalletAdjustDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private WalletAdjust requireOne(String id) {
        return walletAdjustRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
