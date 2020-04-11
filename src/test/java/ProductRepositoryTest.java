import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Product first = new Book(1, "Ромео и Джульетта", 250, "Шекспир");
    private Product second = new Smartphone(2, "Sumsung j3", 5600, "Sumsung");
    private Product third = new Book(3, "Алхимик", 200, "Пауло Коэльо");


    @BeforeEach
    void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    void shouldRemovedByIdExist() {
        int idToRemove = 3;
        repository.removedById(idToRemove);
        assertArrayEquals(new Product[]{first, second}, repository.findAll());
    }

    @Test
    void souldRemovedByIdNotExist() {
        int idToRemove = 5;
        assertThrows(NotFoundException.class, () -> repository.removedById(idToRemove));
        assertArrayEquals(new Product[]{first, second, third}, repository.findAll());
    }
}
