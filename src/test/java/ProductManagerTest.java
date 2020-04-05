import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ProductManagerTest {
    private ProductManager manager = new ProductManager(new ProductRepository());
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
    void shouldSearchByExist() {
        assertArrayEquals(new Product[]{first}, manager.searchBy("Ромео и Джульетта"));
        assertArrayEquals(new Product[]{fourth}, manager.searchBy("iPhone6"));
    }

    @Test
    void shouldSearchByNotExist() {
        assertArrayEquals(new Product[]{}, manager.searchBy("Том Сойер"));
    }
}