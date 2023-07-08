package com.agussuhardi.wallet.vo;

import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;


public record WalletAdjustVO(@NotNull(message = "userId can not null") String userId,
                             @NotNull(message = "adjust can not null") BigDecimal adjust

) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


}
