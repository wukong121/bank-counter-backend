package com.mastercard.paymenttransfersystem.domain.account.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * The DTO sent by the client to process a transfer request
 */
@Data
@AllArgsConstructor
public class TransferRequestDTO {
    private Long recipientAccountId;
    private BigDecimal amount;
    private String currency;
}