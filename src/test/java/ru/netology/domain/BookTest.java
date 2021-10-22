package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book book = new Book(1, "Jane Eyre", 600, "Bronte");

    @Test
    public void shouldUseNoArgsConstructor() {
    }

    @Test
    public void shouldUseAllArgsConstructor() {

        Book book = new Book();

        book.setName("Jane Eyre");
        book.setId(1);
        book.setPrice(600);
        book.setAuthor("Bronte");

        assertEquals("Jane Eyre", book.getName());
        assertEquals(1, book.getId());
        assertEquals(600, book.getPrice());
        assertEquals("Bronte", book.getAuthor());
    }
}