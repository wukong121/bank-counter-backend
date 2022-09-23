package com.mastercard.paymenttransfersystem.domain.transaction.service;

import com.mastercard.paymenttransfersystem.domain.transaction.model.Transaction;
import com.mastercard.paymenttransfersystem.domain.transaction.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

    private TransactionService transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    @BeforeEach
    void setUp() {
        transactionService = new TransactionService(transactionRepository);
    }

    @Test
    void Get_latest_transactions_successfully() {
        // Given
        Long accountId = 3334L;
        Transaction transaction1 = new Transaction(1L, accountId, 433L, BigDecimal.TEN, "USD", ZonedDateTime.now(), ZonedDateTime.now());
        Transaction transaction2 = new Transaction(2L, 433L, accountId, BigDecimal.TEN, "USD", ZonedDateTime.now(), ZonedDateTime.now());
        given(transactionRepository.findLatestTransactions(accountId, 20L)).willReturn(List.of(transaction1, transaction2));

        // When
        Collection<Transaction> latestTransactions = transactionService.getLatestTransactions(3334L, 20L);

        // Then
        verify(transactionRepository).findLatestTransactions(accountId, 20L);
        assertEquals(List.of(transaction1, transaction2), latestTransactions);
    }

    @Test
    void Save_transaction_successfully() {
        // Given
        Transaction transaction = new Transaction(1L, 988L, 433L, BigDecimal.TEN, "USD", ZonedDateTime.now(), ZonedDateTime.now());
        given(transactionService.saveTransaction(transaction)).willReturn(transaction);

        // When
        Transaction actualTransaction = transactionService.saveTransaction(transaction);

        // Then
        verify(transactionRepository).save(transaction);
        assertNotNull(actualTransaction);
        assertEquals(transaction, actualTransaction);
    }
}
