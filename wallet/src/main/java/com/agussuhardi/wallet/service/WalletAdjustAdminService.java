package com.agussuhardi.wallet.service;

import com.agussuhardi.library.dto.CreateDTO;
import com.agussuhardi.wallet.dto.WalletAdjustDTO;
import com.agussuhardi.wallet.vo.WalletAdjustQueryVO;
import com.agussuhardi.wallet.vo.WalletAdjustVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author agussuhardi
 * @created 08/07/23/07/2023 :12.41
 * @project spring-boot-multimodule
 */
public interface WalletAdjustAdminService {
    CreateDTO add(WalletAdjustVO vO);

    WalletAdjustDTO getById(String id);

    Page<WalletAdjustDTO> query(WalletAdjustQueryVO vO, Pageable pageable);
}
