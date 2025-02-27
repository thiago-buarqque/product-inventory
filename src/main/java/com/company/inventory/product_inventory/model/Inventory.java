package com.company.inventory.product_inventory.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    private int quantity;
    private List<Warehouse> warehouses;

    public Inventory(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
        getQuantity();
    }

    public void quantity(){
        this.quantity =  getQuantity();
    }

    public int getQuantity() {
        int quantity = 0;
        for (Warehouse warehouse : warehouses) {
            quantity += warehouse.getQuantity();
        }
        return quantity;
    }
}
