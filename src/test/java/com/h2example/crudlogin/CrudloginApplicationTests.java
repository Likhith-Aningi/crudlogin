package com.h2example.crudlogin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrudloginApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("test begin..............");
		assertEquals(5, 3+2);
	}

}
