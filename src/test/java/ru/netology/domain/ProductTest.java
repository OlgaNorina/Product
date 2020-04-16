package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void shouldBookEquals() {
        Product first = new Book(1, "Ромео и Джульетта", 250, "Шекспир");
        Product second = new Book(1, "Ромео и Джульетта", 250, "Шекспир");

        assertEquals(first, second);
    }

    @Test
    void shouldSmartphoneEquals() {
        Product first = new Smartphone(2, "Sumsung j3", 5600, "Sumsung");
        Product second = new Smartphone(2, "Sumsung j3", 5600, "Sumsung");

        assertEquals(first, second);
    }
}