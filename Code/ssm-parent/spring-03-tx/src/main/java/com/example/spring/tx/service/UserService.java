package com.example.spring.tx.service;

import org.springframework.stereotype.Service;


public interface UserService {
    // 用户结账
    void checkout(String username, Integer bookId, Integer byNum);
}
