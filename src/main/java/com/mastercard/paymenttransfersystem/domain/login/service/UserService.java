package com.mastercard.paymenttransfersystem.domain.login.service;

import com.mastercard.paymenttransfersystem.domain.login.model.User;

public interface UserService {
    
    User getUserByPhone(String phone);
    
    User getUserByEmail(String email);
    
    User createUser(User user);
    
    User updateUser(Long userId, User user);
    
    User deleteUser(Long userId);
    
}
