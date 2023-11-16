package com.mastercard.paymenttransfersystem.domain.transaction.service;

import com.mastercard.paymenttransfersystem.domain.transaction.model.Transaction;

import java.util.Collection;

public interface TransactionService {

    /**
     * Retrieve the latest transaction of a given account
     * @param accountId an identifier belonging to an account
     * @param numberOfTransactions the number of transaction to be returned by the method
     * @return a collection of the latest transactions of a given account
     */
    Collection<Transaction> getLatestTransactions(Long accountId, Long numberOfTransactions);

    /**
     * Create a new transaction in the repository
     * @param transaction an object representing the transaction that is to be created
     * @return the newly created transaction object
     */
    Transaction saveTransaction(Transaction transaction);
}