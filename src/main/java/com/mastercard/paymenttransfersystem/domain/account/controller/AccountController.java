package com.mastercard.paymenttransfersystem.domain.account.controller;

import com.mastercard.paymenttransfersystem.domain.account.controller.dto.*;
import com.mastercard.paymenttransfersystem.domain.account.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The controller that serves HTTP endpoints for the account domain
 */
@RestController
@RequestMapping("api/v1/accounts")
@RequiredArgsConstructor
@Tag(name = "Account")
public class AccountController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @GetMapping(path = "/{accountId}/balance")
    @Operation(summary = "Get the balance of an account")
    @ApiResponse(responseCode = "200", description = "Retrieved account balance")
    @ApiResponse(responseCode = "404", description = "Account with given id not found")
    public AccountBalanceDTO getAccountBalance(@PathVariable Long accountId) {
        return accountMapper.toBalanceDTO(accountService.getAccountById(accountId));
    }

    @GetMapping(path = "/{accountId}/statements/mini")
    @Operation(summary = "Get the a mini statement of an account")
    @ApiResponse(responseCode = "200", description = "Retrieved mini account statement")
    @ApiResponse(responseCode = "404", description = "Account with given id not found")
    public List<AccountStatementItemDTO> getMiniStatement(@PathVariable Long accountId) {
        return accountMapper.toStatementDTOList(accountService.getMiniStatement(accountId));
    }

    @PutMapping(path = "/{accountId}/transfer")
    @Operation(summary = "Transfer an amount from one account to another")
    @ApiResponse(responseCode = "200", description = "Retrieved mini account statement")
    @ApiResponse(responseCode = "404", description = "Account with given id not found")
    @ApiResponse(responseCode = "400", description = "Insufficient funds")
    @ApiResponse(responseCode = "400", description = "Invalid transfer amount")
    @ApiResponse(responseCode = "400", description = "Cannot transfer to own account")
    public AccountBalanceDTO transferMoney(@PathVariable Long accountId, @RequestBody @Validated TransferRequestDTO dto) {
        return accountMapper.toBalanceDTO(accountService.transferMoney(accountId, dto.getRecipientAccountId(), dto.getAmount()));
    }

    @GetMapping(path = "/{accountId}")
    @Operation(summary = "Get the details of an account")
    @ApiResponse(responseCode = "200", description = "Retrieved account details")
    @ApiResponse(responseCode = "404", description = "Account with given id not found")
    public AccountDTO getAccount(@PathVariable Long accountId) {
        return accountMapper.toDTO(accountService.getAccountById(accountId));
    }


    @GetMapping
    @Operation(summary = "Get all accounts in the system")
    @ApiResponse(responseCode = "200", description = "Retrieved all accounts")
    public List<AccountDTO> getAccounts() {
        return accountMapper.toDTO(accountService.getAll());
    }

    @PostMapping
    @Operation(summary = "Create a new account")
    @ApiResponse(responseCode = "200", description = "Account created")
    public AccountDTO createAccount(@RequestBody AccountDTO dto) {
        return accountMapper.toDTO(accountService.createAccount(accountMapper.toModel(dto)));
    }

    @PutMapping(path = "/{accountId}")
    @Operation(summary = "Update an existing account")
    @ApiResponse(responseCode = "200", description = "Account updated")
    @ApiResponse(responseCode = "404", description = "Account with given id not found")
    public AccountDTO updateAccount(@PathVariable Long accountId, @RequestBody AccountDTO dto) {
        return accountMapper.toDTO(accountService.updateAccount(accountId, accountMapper.toModel(dto)));
    }

    @Operation(summary = "Mark an existing account for deletion")
    @ApiResponse(responseCode = "200", description = "Account marked for deletion")
    @ApiResponse(responseCode = "404", description = "Account with given id not found")
    @DeleteMapping("/{accountId}")
    public AccountDTO deleteAccount(@PathVariable Long accountId) {
        return accountMapper.toDTO(accountService.deleteAccount(accountId));
    }
}