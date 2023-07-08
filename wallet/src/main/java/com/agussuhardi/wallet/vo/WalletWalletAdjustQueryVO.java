package com.agussuhardi.wallet.vo;


import com.agussuhardi.library.vo.QueryVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class WalletWalletAdjustQueryVO extends QueryVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

}
