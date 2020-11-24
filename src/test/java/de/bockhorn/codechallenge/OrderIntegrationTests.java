package de.bockhorn.codechallenge;

import de.bockhorn.codechallenge.model.Order;
import de.bockhorn.codechallenge.model.Product;
import de.bockhorn.codechallenge.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderIntegrationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private OrderService orderService;

    @Test
    void testOrderCreation() throws Exception {
        mvc.perform(post("/post")
                .contentType("application/json")
                .content("{\"orderID\":1,\"products\":[{\"name\":\"Produkt 2\",\"amount\":3},{\"name\":\"Produkt 3\",\"amount\":5}]}"))
                .andExpect(status().isCreated());

        Order order = orderService.findAll().get(0);
        assertThat(order.getOrderID() == 1L);
    }

    @Test
    void testOrderLoading() throws Exception {
        Product p1 = new Product();
        p1.setName("Produkt A");
        p1.setAmount(3);
        Order order = new Order(1, Collections.singletonList(p1));
        orderService.save(order);

        mvc.perform(get("/get"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"orderID\":1,\"products\":[{\"name\":\"Produkt A\",\"amount\":3}]}]"));
    }

}
