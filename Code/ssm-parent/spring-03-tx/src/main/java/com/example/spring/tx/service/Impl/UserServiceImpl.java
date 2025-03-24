package com.example.spring.tx.service.Impl;

import com.example.spring.tx.bean.Book;
import com.example.spring.tx.dao.AccountDAO;
import com.example.spring.tx.dao.BookDAO;
import com.example.spring.tx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private BookDAO bookDAO;
    @Autowired
    private AccountDAO accountDAO;
    @Transactional
    @Override
    public void checkout(String username, Integer bookId, Integer buyNum) {
        // 1. 查询图书信息
        Book book = bookDAO.getBookById(bookId);
        BigDecimal price = book.getPrice();
        // 2. 计算扣减金额
        BigDecimal total = new BigDecimal(buyNum).multiply(price);
        // 3. 扣减余额
        accountDAO.updateAccountBalance(username, total);
        // 4. 扣减库存
        bookDAO.updateBookStock(bookId, buyNum);

    }
}
