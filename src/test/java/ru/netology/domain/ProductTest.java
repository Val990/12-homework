package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product product = new Product();

    @Test
    public void shouldUseNoArgsConstructor() {
    }

    @Test
    public void shouldGetAuthor() {

        product.setName("Phone");
        product.setId(1);
        product.setPrice(3_000);

        assertEquals("Phone", product.getName());
        assertEquals(1, product.getId());
        assertEquals(3_000, product.getPrice());
    }
}