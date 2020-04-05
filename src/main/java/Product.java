import lombok.Data;

@Data
public class Product {
    private int id;
    private String nameProduct;
    private int price;

    public Product(int id, String nameProduct, int coast) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = coast;
    }
}
