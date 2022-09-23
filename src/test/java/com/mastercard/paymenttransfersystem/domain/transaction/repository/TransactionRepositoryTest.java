package com.mastercard.paymenttransfersystem.domain.transaction.repository;

import com.mastercard.paymenttransfersystem.domain.transaction.model.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
public class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    void findLatestTransactionsTest() {
        // Given
        ArrayList<Transaction> transactions = new ArrayList<>();
        for(int i = 0; i < 25; i++) {
            transactions.add(new Transaction(i+1L, 999L, 888L, BigDecimal.valueOf(6000), "USD", null, null));
        }
        transactionRepository.saveAll(transactions);

        // When
        List<Transaction> actualLatest = transactionRepository.findLatestTransactions(999L, 20L);

        // Then
        assertNotNull(actualLatest);
        assertEquals(20, actualLatest.size());
    }
}