package com.agussuhardi.wallet.dto;


import com.agussuhardi.wallet.entity.enumeric.WalletAdjustStatus;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class WalletAdjustDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String id;

    private String userId;

    private BigDecimal adjust;

    private WalletAdjustStatus status;

}
