package com.example.spring.tx;

import com.example.spring.tx.bean.Book;
import com.example.spring.tx.dao.AccountDAO;
import com.example.spring.tx.dao.BookDAO;
import com.example.spring.tx.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Spring03TxApplicationTests {

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	BookDAO bookDAO;

	@Autowired
	AccountDAO accountDAO;

	@Test
	void testAccountUpdate() {
		accountDAO.updateAccountBalance("zhangsan", new BigDecimal("9.9"));
	}

	@Test
	void testDelete() {
		bookDAO.deleteBook(4);
	}

	@Test
	void testUpdate() {
		bookDAO.updateBookStock(4, 2);
	}

	@Test
	void testAdd() {
		Book book = new Book();
		book.setBookName("java");
		book.setPrice(new BigDecimal("10.8"));
		book.setStock(10);
		bookDAO.addBook(book);
	}

	@Test
	void testQuery() {
		Book bookById = bookDAO.getBookById(1);
		System.out.println("bookById = " + bookById);
	}

	@Test
	void contextLoads() throws SQLException {
		Connection connection = dataSource.getConnection();
		System.out.println("connection = " + connection);
	}

}
