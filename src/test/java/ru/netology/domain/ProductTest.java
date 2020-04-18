package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductTest {
    ProductRepository repositoty = new ProductRepository();
    ProductManager manager = new ProductManager(repositoty);
    private Product first = new Book(1, "Ромео и Джульетта", 250, "Шекспир");
    private Product second = new Smartphone(2, "Sumsung j3", 5600, "Sumsung");
    private Product third = new Book(3, "Алхимик", 200, "Пауло Коэльо");
    private Product fourth = new Smartphone(4, "iPhone6", 11000, "Apple");
    private Product fifth = new Book(5, "Гарри Поттер", 450, "Дж. К. Роулинг");

    @BeforeEach
    void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    void shouldProductEquals() {
        assertTrue(second.matches("Sumsung j3"));
        assertTrue(third.matches("Алхимик"));
        assertTrue(fourth.matches("Apple"));
        assertTrue(fifth.matches("Дж. К. Роулинг"));
        assertTrue(first.matches("Шекспир"));
    }

    @Test
    void shouldProductNotEquals() {
        assertFalse(second.matches("Самсунг"));
        assertFalse(first.matches("iPhone6"));
    }
}