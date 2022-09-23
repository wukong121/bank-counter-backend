package com.mastercard.paymenttransfersystem.domain.transaction.repository;

import com.mastercard.paymenttransfersystem.domain.transaction.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    /**
     * An SQL query that returns a limited list of transactions related to a given account id,
     * sorted by the date of creation (descending).
     * @return
     */
    @Query(value = "SELECT t.* from transaction t WHERE t.recipient_account_id = ?1 OR t.sender_account_id = ?1 ORDER BY t.created_at DESC LIMIT ?2",
    nativeQuery = true)
    List<Transaction> findLatestTransactions(Long accountId, Long numberOfTransactions);
}