package com.mastercard.paymenttransfersystem.domain.account.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * A model for representing an item/transaction on an account statement
 */
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class AccountStatementItem {
    private Long accountId;
    private BigDecimal amount;
    private String currency;
    private AccountStatementItemType type;
    private ZonedDateTime transactionDate;
}