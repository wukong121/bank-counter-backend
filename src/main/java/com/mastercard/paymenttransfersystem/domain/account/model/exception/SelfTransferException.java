package com.mastercard.paymenttransfersystem.domain.account.model.exception;

/**
 * An exception thrown an account tries to transfer to itself
 */
public class SelfTransferException extends RuntimeException{
    public SelfTransferException() {
        super(String.format("Sender and recipient must be different"));
    }
}