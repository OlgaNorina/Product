package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Smartphone extends Product {
    String producerSmart;

    public Smartphone(int id, String nameProduct, int coast, String producerSmart) {
        super(id, nameProduct, coast);
        this.producerSmart = producerSmart;
    }
}
