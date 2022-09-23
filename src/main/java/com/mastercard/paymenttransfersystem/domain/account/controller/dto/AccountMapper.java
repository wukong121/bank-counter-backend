package com.mastercard.paymenttransfersystem.domain.account.controller.dto;

import com.mastercard.paymenttransfersystem.domain.account.model.Account;
import com.mastercard.paymenttransfersystem.domain.account.model.AccountState;
import com.mastercard.paymenttransfersystem.domain.account.model.AccountStatementItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A mapper class that maps to and from DTO objects concerning the account domain
 */
@Component
@RequiredArgsConstructor
public class AccountMapper {

    public AccountBalanceDTO toBalanceDTO(Account account) {
        return AccountBalanceDTO.builder()
                .accountId(account.getId())
                .balance(account.getBalance())
                .currency(account.getCurrency())
                .build();
    }

    public AccountStatementItemDTO toStatementDTO(AccountStatementItem item) {
        return AccountStatementItemDTO.builder()
                .accountId(item.getAccountId())
                .amount(item.getAmount())
                .type(item.getType().name())
                .currency(item.getCurrency())
                .transactionDate(item.getTransactionDate())
                .build();
    }

    public AccountDTO toDTO(Account account) {
        return AccountDTO.builder()
                .id(account.getId())
                .balance(account.getBalance())
                .currency(account.getCurrency())
                .state(account.getState().name())
                .createdAt(account.getCreatedAt())
                .modifiedAt(account.getModifiedAt())
                .build();
    }

    public Account toModel(AccountDTO dto) {
        return Account.builder()
                .id(dto.getId())
                .balance(dto.getBalance())
                .currency(dto.getCurrency())
                .state(AccountState.valueOf(dto.getState()))
                .createdAt(dto.getCreatedAt())
                .modifiedAt(dto.getModifiedAt())
                .build();
    }

    public List<AccountDTO> toDTO(List<Account> accounts) {
        return accounts.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<AccountStatementItemDTO> toStatementDTOList(List<AccountStatementItem> items) {
        return items.stream().map(this::toStatementDTO).collect(Collectors.toList());
    }


}