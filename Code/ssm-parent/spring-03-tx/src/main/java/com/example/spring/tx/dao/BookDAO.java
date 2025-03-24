package com.example.spring.tx.dao;

import com.example.spring.tx.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 按照id查图书
     * @param id
     * @return
     */
    public Book getBookById(Integer id) {
        String sql = "select id, bookName, price, stock from book where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
    }

    /**
     * 新增图书
     * @param book
     */
    public void addBook(Book book) {
        String sql = "insert into book(bookName, price, stock) values(?, ?, ?)";
        jdbcTemplate.update(sql, book.getBookName(), book.getPrice(), book.getStock());
    }

    /**
     * 按照id修改图书库存
     * @param id
     * @param num 要减少的数量
     */
    public void updateBookStock(Integer id, int num) {
        String sql = "update book set stock = stock - ? where id = ?";
        jdbcTemplate.update(sql, num, id);
    }

    public void deleteBook(Integer id) {
        String sql = "delete from book where id = ?";
        jdbcTemplate.update(sql, id);
    }
}
