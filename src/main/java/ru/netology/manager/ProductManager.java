package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.repository.ProductRepository;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

@AllArgsConstructor
@Data
public class ProductManager {
    private ProductRepository repository;

    public void add(Product item) {
        repository.save(item);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getNameProduct().equalsIgnoreCase(search)) {
            return true;
        }
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getProducerSmart().equalsIgnoreCase(search)) {
                return true;
            }
        }
        return false;
    }
}
