package com.mastercard.paymenttransfersystem.domain.account.model.exception;

/**
 * An exception thrown when no account with a given id is in the system
 */
public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(long accountId) {
        super(String.format("Account with id '%s' not found", accountId));
    }
}