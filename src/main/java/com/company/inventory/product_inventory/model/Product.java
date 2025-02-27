package com.company.inventory.product_inventory.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private Integer sku;
    private String name;
    private Inventory inventory;
    private boolean isMarketable;

    public Product(int sku, String name, Inventory inventory) {
        this.sku = sku;
        this.name = name;
        this.inventory = inventory;
        updateMarketableStatus();
    }

    public void updateMarketableStatus() {
        this.isMarketable = inventory.getQuantity() > 0;
    }

    public Integer getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public boolean isMarketable() {
        return isMarketable;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setMarketable(boolean marketable) {
        isMarketable = marketable;
    }
}
