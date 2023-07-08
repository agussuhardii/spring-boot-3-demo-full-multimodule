package com.agussuhardi.wallet.repository;

import com.agussuhardi.wallet.entity.WalletCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WalletCreditRepository extends JpaRepository<WalletCredit, String>, JpaSpecificationExecutor<WalletCredit> {

}