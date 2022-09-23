package com.mastercard.paymenttransfersystem.domain.account.controller.dto;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * The DTO returned when details of an account is requested
 */
@Data
@Builder(toBuilder = true)
public class AccountDTO {
    private Long id;
    private BigDecimal balance;
    private String currency;
    private String state;
    private ZonedDateTime createdAt;
    private ZonedDateTime modifiedAt;
}