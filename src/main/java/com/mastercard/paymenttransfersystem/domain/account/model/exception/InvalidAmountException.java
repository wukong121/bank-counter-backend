package com.mastercard.paymenttransfersystem.domain.account.model.exception;

/**
 * An exception thrown an account tries to transfer an negative amount
 */
public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException() {
        super(String.format("Amount must be greater than 0"));
    }
}