package com.mastercard.paymenttransfersystem.domain.account.service;

import com.mastercard.paymenttransfersystem.domain.account.model.Account;
import com.mastercard.paymenttransfersystem.domain.account.model.AccountStatementItem;

import java.math.BigDecimal;
import java.util.List;

public interface IAccountService {

    /**
     * Retrieve an account from the repository, given the accountId provided
     * @param accountId an identifier belonging to an account
     * @return the account retrieved from the repository
     */
    Account getAccountById(Long accountId);

    /**
     * Retrieve a statement of the latest transactions of a particular account
     * @param accountId an identifier belonging to an account
     * @return a representation of the latest statements of the account
     */
    List<AccountStatementItem> getMiniStatement(Long accountId);

    /**
     * Transfer an amount from one account to another
     * @param senderAccountId an identifier belonging to the sender
     * @param recipientAccountId an identifier belonging to the recipient
     * @param amount the amount of money that is transferred from the sender to the recipient
     * @return the updated account details of the sender
     */
    Account transferMoney(Long senderAccountId, Long recipientAccountId, BigDecimal amount);

    /**
     * Retrieve all accounts in the repository
     * @return a list containing all account objects in the repository
     */
    List<Account> getAll();

    /**
     * Create a new account in the repository
     * @param account an object representing the account that is to be created
     * @return the newly created account object
     */
    Account createAccount(Account account);

    /**
     * Update an existing account in the repository
     * @param accountId an identifier belonging to the account that is to be updated
     * @param account an object holdning the new values for the account
     * @return the updated account object
     */
    Account updateAccount(Long accountId, Account account);

    /**
     * Mark an existing account for deletion
     * @param accountId an identifier belonging to the account that is to be marked for deletion
     * @return the marked created account object
     */
    Account deleteAccount(Long accountId);
}