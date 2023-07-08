package com.agussuhardi.wallet.service;

import com.agussuhardi.library.dto.CreateDTO;
import com.agussuhardi.wallet.dto.WalletWalletAdjustDTO;
import com.agussuhardi.wallet.vo.WalletWalletAdjustQueryVO;
import com.agussuhardi.wallet.vo.WalletWalletAdjustVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author agussuhardi
 * @created 08/07/23/07/2023 :12.41
 * @project spring-boot-multimodule
 */
public interface WalletAdjustAdminService {
    CreateDTO add(WalletWalletAdjustVO vO);

    WalletWalletAdjustDTO getById(String id);

    Page<WalletWalletAdjustDTO> query(WalletWalletAdjustQueryVO vO, Pageable pageable);
}
