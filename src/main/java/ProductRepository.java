import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.manager.NotFoundException;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRepository {
    private Product[] items = new Product[0];
    NotFoundException exception = new NotFoundException();

    public Product[] findAll() {
        return items;
    }

    public void save(Product item) {
        int lenght = items.length + 1;
        Product[] tmp = new Product[lenght];

        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removedById(int id) {
        Product result = findById(id);
        if(result == null ) throw new NotFoundException("Element with id: " + id + " not found");
        int lenght = items.length - 1;
        Product[] tmp = new Product[lenght];
        int index = 0;

        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
