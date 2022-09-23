package com.mastercard.paymenttransfersystem.domain.account.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * A DTO returned when the balance of an account is requested
 */
@Data
@Builder(toBuilder = true)
public class AccountBalanceDTO {
    private Long accountId;
    private BigDecimal balance;
    private String currency;
}