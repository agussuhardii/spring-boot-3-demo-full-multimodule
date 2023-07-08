package com.agussuhardi.wallet.entity;

import com.agussuhardi.library.entity.BaseEntity;
import com.agussuhardi.wallet.entity.enumeric.WalletAdjustStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(schema = "wallet", name = "wallet_adjust")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@SuperBuilder(toBuilder = true)
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "update wallet.wallet_adjust set is_deleted=true where id=?")
@Where(clause = "is_deleted=false")
@FieldNameConstants
public class WalletAdjust extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "adjust", nullable = false)
    private BigDecimal adjust;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
        private WalletAdjustStatus status;

    @Version
    @Setter(AccessLevel.NONE)
    private Long version;

}
