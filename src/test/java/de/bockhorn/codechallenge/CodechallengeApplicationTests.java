package de.bockhorn.codechallenge;

import de.bockhorn.codechallenge.controller.OrderController;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CodechallengeApplicationTests {

	@Autowired
	private OrderController orderController;

	@Test
	void contextLoads() {
		assertThat(orderController).isNotNull();
	}
}
