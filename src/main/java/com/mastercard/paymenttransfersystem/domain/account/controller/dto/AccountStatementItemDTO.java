package com.mastercard.paymenttransfersystem.domain.account.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * The DTO returned when an account statement is requested
 */
@Data
@Builder(toBuilder = true)
public class AccountStatementItemDTO {
    private Long accountId;
    private BigDecimal amount;
    private String currency;
    private String type;
    private ZonedDateTime transactionDate;
}