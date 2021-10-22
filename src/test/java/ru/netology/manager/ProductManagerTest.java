package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    private Product product1 = new Book(1, "Jane Eyre", 600, "Bronte");
    private Product product2 = new Book(2, "Three Men in a Boat", 700, "Jerome");
    private Product product3 = new Smartphone(3, "Iphone", 20_000, "China");
    private Product product4 = new Smartphone(4, "Xiaomi", 15_000, "China");

    @Test
    public void shouldFindByBookName() {

        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(product4);

        Product[] actual = manager.searchBy("Jane Eyre");
        Product[] expected = new Product[]{product1};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByBookAuthor() {

        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(product4);

        Product[] actual = manager.searchBy("Jerome");
        Product[] expected = new Product[]{product2};

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindTheSameManufacturer() {

        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(product4);

        Product[] expected = new Product[]{product3, product4};
        Product[] actual = manager.searchBy("China");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowNull() {

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("!!!");

        assertArrayEquals(expected, actual);
    }
}


class ProductManagerBookTest {

    private Book book1 = new Book(1, "Jane Eyre", 600, "Bronte");
    private Book book2 = new Book(2, "Three Men in a Boat", 700, "Jerome");
    private Book book3 = new Book(3, "Alice's Adventures in Wonderland", 500, "Carroll");

    @Test
    void shouldSearchBookByName() {

        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);


        Product[] actual = manager.searchBy("Jane Eyre");
        Product[] expected = new Book[]{book1};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByAuthor() {

        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Jerome");
        Product[] expected = new Book[]{book2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookNoExist() {

        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Through the Looking-Glass");
        Product[] expected = new Book[]{};

        assertArrayEquals(expected, actual);
    }
}

class ProductManagerSmartphoneTest {

    private Smartphone smartphone1 = new Smartphone(1, "Iphone", 20_000, "China");
    private Smartphone smartphone2 = new Smartphone(2, "Xiaomi", 15_000, "China");
    private Smartphone smartphone3 = new Smartphone(3, "iPhoneX", 17_000, "Apple");
    private Smartphone smartphone4 = new Smartphone(4, "Samsung Galaxy", 13_000, "Samsung");


    @Test
    void shouldSearchSmartphoneByName() {

        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        Product[] actual = manager.searchBy("Samsung Galaxy");
        Product[] expected = new Smartphone[]{smartphone4};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByManufacturer() {

        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        Product[] actual = manager.searchBy("China");
        Product[] expected = new Smartphone[]{smartphone1, smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneNoExist() {

        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        Product[] actual = manager.searchBy("Redmi");
        Product[] expected = new Smartphone[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldUseNoArgsConstructor() {
    }
}


