package com.agussuhardi.wallet.entity;

import com.agussuhardi.library.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(schema = "wallet", name = "credit")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@SuperBuilder(toBuilder = true)
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "update wallet.credit set is_deleted=true where id=?")
@Where(clause = "is_deleted=false")
@FieldNameConstants
public class WalletCredit extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "credit", nullable = false)
    private BigDecimal credit;

    @Version
    @Setter(AccessLevel.NONE)
    private Long version;
}
