package com.agussuhardi.wallet.repository;

import com.agussuhardi.wallet.entity.WalletAdjust;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WalletAdjustRepository extends JpaRepository<WalletAdjust, String>, JpaSpecificationExecutor<WalletAdjust> {

}