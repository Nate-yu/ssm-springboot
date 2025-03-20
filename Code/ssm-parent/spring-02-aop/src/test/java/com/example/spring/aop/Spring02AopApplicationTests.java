package com.example.spring.aop;

import com.example.spring.aop.calculator.MathCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Spring02AopApplicationTests {

	@Autowired
	MathCalculator mathCalculator;

	@Test
	void contextLoads() {
		int result = mathCalculator.add(1, 2);
		System.out.println(result);
	}

}
