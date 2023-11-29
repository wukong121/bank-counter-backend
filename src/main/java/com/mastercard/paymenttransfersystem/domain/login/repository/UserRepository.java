package com.mastercard.paymenttransfersystem.domain.login.repository;

import com.mastercard.paymenttransfersystem.domain.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
