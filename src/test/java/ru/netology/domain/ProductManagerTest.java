package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
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

    @ParameterizedTest
    @CsvFileSource(resources = "/searchByExist.csv")
    void shouldSearchByExist(int index, String text) {
        assertEquals(repository.findAll()[index], manager.searchBy(text)[0]);
    }

    @Test
    void shouldSearchByNotExist() {
        assertArrayEquals(new Product[]{}, manager.searchBy("Том Сойер"));
    }
}