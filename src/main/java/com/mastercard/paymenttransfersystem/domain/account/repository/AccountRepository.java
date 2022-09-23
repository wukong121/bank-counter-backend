package com.mastercard.paymenttransfersystem.domain.account.repository;

import com.mastercard.paymenttransfersystem.domain.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}