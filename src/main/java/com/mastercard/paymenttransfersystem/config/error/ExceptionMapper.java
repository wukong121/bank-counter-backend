package com.mastercard.paymenttransfersystem.config.error;

import com.mastercard.paymenttransfersystem.domain.account.model.exception.AccountNotFoundException;
import com.mastercard.paymenttransfersystem.domain.account.model.exception.InsufficientFundsException;
import com.mastercard.paymenttransfersystem.domain.account.model.exception.InvalidAmountException;
import com.mastercard.paymenttransfersystem.domain.account.model.exception.SelfTransferException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * An exception mapper that handles exceptions thrown in the code.
 * Ensures that a user-friendly error response is returned to the client
 */
@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionMapper {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAccountNotFoundException(AccountNotFoundException e) {
        return logAndGetResponse(HttpStatus.NOT_FOUND.value(), e);
    }

    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<ErrorResponse> handleInsufficientFundsException(InsufficientFundsException e) {
        return logAndGetResponse(HttpStatus.BAD_REQUEST.value(), e);
    }

    @ExceptionHandler(InvalidAmountException.class)
    public ResponseEntity<ErrorResponse> handleInvalidAmountException(InvalidAmountException e) {
        return logAndGetResponse(HttpStatus.BAD_REQUEST.value(), e);
    }

    @ExceptionHandler(SelfTransferException.class)
    public ResponseEntity<ErrorResponse> handleSelfTransferException(SelfTransferException e) {
        return logAndGetResponse(HttpStatus.BAD_REQUEST.value(), e);
    }

    private ResponseEntity<ErrorResponse> logAndGetResponse(int errorCode, Exception e) {
        ErrorResponse response = new ErrorResponse(errorCode, e.getMessage());
        logger.error(e.getMessage(), e);
        return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode));
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class ErrorResponse {
        private Integer errorCode;
        private String message;
    }
}