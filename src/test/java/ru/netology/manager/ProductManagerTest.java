package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    private Book book1 = new Book(1, "Jane Eyre", 600, "Bronte");
    private Book book2 = new Book(2, "Three Men in a Boat", 700, "Jerome");
    private Book book3 = new Book(3, "Iphone", 1_000, "Poug");
    private Smartphone smartphone1 = new Smartphone(4, "Iphone10", 20_000, "Apple");
    private Smartphone smartphone2 = new Smartphone(5, "Xiaomi9", 15_000, "Xioami");
    private Smartphone smartphone3 = new Smartphone(5, "Iphone12", 50_000, "Apple");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    public void shouldFindByBookName() {

        Product[] expected = new Product[]{book1};
        Product[] actual = manager.searchBy("Jane Eyre");


        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindTheSameManufacturer() {

        Product[] expected = new Product[]{smartphone1, smartphone3};
        Product[] actual = manager.searchBy("Apple");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowNull() {

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("!!!");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByAuthor() {

        Product[] expected = new Book[]{book2};
        Product[] actual = manager.searchBy("Jerome");


        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookNoExist() {

        Product[] expected = new Book[]{};
        Product[] actual = manager.searchBy("Through the Looking-Glass");


        assertArrayEquals(expected, actual);
    }


    @Test

    void shouldSearchSmartphoneByName2() {

        Product[] expected = new Smartphone[]{smartphone2};
        Product[] actual = manager.searchBy("Xiaomi9");


        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearchSmartphoneNoExist() {

        Product[] expected = new Smartphone[]{};
        Product[] actual = manager.searchBy("Redmi");


        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductWithSmartphoneName() {

        Product[] expected = new Product[]{book3};
        Product[] actual = manager.searchBy("Poug");

        assertArrayEquals(expected, actual);
    }
}


