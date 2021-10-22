package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    @Test
    void shouldRemoveRepositoryById() {

        ProductRepository repository = new ProductRepository();

        Product product1 = new Book(1, "Jane Eyre", 600, "Bronte");
        Product product2 = new Book(2, "Three Men in a Boat", 700, "Jerome");

        repository.save(product1);
        repository.save(product2);
        Product[] expected = new Product[]{product2};
        repository.removeById(1);
        Product[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }
}