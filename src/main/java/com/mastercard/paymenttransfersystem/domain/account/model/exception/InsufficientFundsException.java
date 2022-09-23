package com.mastercard.paymenttransfersystem.domain.account.model.exception;

/**
 * An exception thrown when an account has not enough balance to perform an operation
 */
public class InsufficientFundsException extends RuntimeException{
    public InsufficientFundsException(long accountId) {
        super(String.format("Account with id '%s' does not have sufficient funds for this request", accountId));
    }
}