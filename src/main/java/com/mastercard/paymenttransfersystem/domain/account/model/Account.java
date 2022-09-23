package com.mastercard.paymenttransfersystem.domain.account.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * A model for representing a transaction in the system
 */
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal balance;
    private String currency;
    private AccountState state;
    @Generated(GenerationTime.INSERT)
    @Column(updatable = false, insertable = false)
    private ZonedDateTime createdAt;
    @Generated(GenerationTime.INSERT)
    @Column(updatable = false, insertable = false)
    private ZonedDateTime modifiedAt;
}