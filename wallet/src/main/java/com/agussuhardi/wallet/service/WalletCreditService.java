package com.agussuhardi.wallet.service;

import com.agussuhardi.wallet.dto.WalletCreditDTO;
import com.agussuhardi.wallet.entity.WalletAdjust;
import com.agussuhardi.wallet.vo.WalletCreditQueryVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author agussuhardi
 * @created 08/07/23/07/2023 :12.28
 * @project spring-boot-multimodule
 */
public interface WalletCreditService {
    void addByAdmin(WalletAdjust adjust);

    WalletCreditDTO getByUser(String userId);

    Page<WalletCreditDTO> queryByAdmin(WalletCreditQueryVO vO, Pageable pageable);
}
