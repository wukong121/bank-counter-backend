package com.mastercard.paymenttransfersystem.domain.account.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * The DTO sent by the client to process a transfer request
 */
@Data
@AllArgsConstructor
public class TransferRequestDTO {
    @NotNull(message = "recipientAccountId is required")
    private Long recipientAccountId;
    @NotNull(message = "amount is required")
    private BigDecimal amount;
    @NotBlank(message = "currency is required")
    private String currency;
}