package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    private Smartphone smartphone = new Smartphone(3, "Iphone", 20_000, "China");

    @Test
    public void shouldUseNoArgsConstructor() {
    }

    @Test
    public void shouldUseAllArgsConstructor() {

        Smartphone smartphone = new Smartphone();

        smartphone.setName("Iphone");
        smartphone.setId(3);
        smartphone.setPrice(20_000);
        smartphone.setManufacturer("China");

        assertEquals("Iphone", smartphone.getName());
        assertEquals(3, smartphone.getId());
        assertEquals(20_000, smartphone.getPrice());
        assertEquals("China", smartphone.getManufacturer());
    }
}