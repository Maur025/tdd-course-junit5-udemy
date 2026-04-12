package com.sergiotrapiello.cursotesting;

import org.junit.jupiter.api.Test;

class HelloWorldTest {

	/**
	 * Este no es un buen ejemplo de como debería hacerse un buen test xd
	 */
	@Test
	void test1() {
		System.out.println(new HelloWorld().greet());
	}

}
