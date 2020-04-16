package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Book extends Product {
    String author;

    public Book(int id, String nameProduct, int price, String author) {
        super(id, nameProduct, price);
        this.author = author;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)){
            return true;
        }
        return super.matches(search) || getAuthor().equalsIgnoreCase(search);
    }
}
