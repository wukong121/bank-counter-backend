package com.mastercard.paymenttransfersystem.domain.login.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String phone;
    
    private String email;
    
    private String password;
    
    @Generated(GenerationTime.INSERT)
    @Column(updatable = false, insertable = false)
    private ZonedDateTime createdAt;
    
    @Generated(GenerationTime.INSERT)
    @Column(updatable = false, insertable = false)
    private ZonedDateTime modifiedAt;
}
