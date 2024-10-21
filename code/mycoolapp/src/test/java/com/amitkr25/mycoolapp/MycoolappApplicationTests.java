package com.amitkr25.mycoolapp;

import com.amitkr25.mycoolapp.rest.FunRestController;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;

@SpringBootTest
class MycoolappApplicationTests {
	private FunRestController funRestController;

	@Test
	void contextLoads() {
	}

	@Test
	public void testHelloWorldController() {
		funRestController = new FunRestController();
		Assertions.assertEquals(funRestController.sayHello(), "Hello World");
	}

}
