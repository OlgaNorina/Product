package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
    private int id;
    private String nameProduct;
    private int price;

    public boolean matches(String search) {
        if (getNameProduct().equalsIgnoreCase(search)) {
            return true;
        }
        return false;
    }
}
