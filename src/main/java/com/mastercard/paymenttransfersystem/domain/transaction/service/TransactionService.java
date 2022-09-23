package com.mastercard.paymenttransfersystem.domain.transaction.service;

import com.mastercard.paymenttransfersystem.domain.transaction.model.Transaction;
import com.mastercard.paymenttransfersystem.domain.transaction.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * The service that handles requested operations for the transaction domain
 */
@Service
@RequiredArgsConstructor
public class TransactionService implements ITransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public Collection<Transaction> getLatestTransactions(Long accountId, Long numberOfTransactions) {
        return transactionRepository.findLatestTransactions(accountId, numberOfTransactions);
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}