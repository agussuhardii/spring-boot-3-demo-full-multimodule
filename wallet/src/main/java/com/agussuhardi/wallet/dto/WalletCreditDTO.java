package com.agussuhardi.wallet.dto;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class WalletCreditDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String userId;

    private BigDecimal credit;

}
