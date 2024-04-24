package com.example.Shop;


import com.example.Shop.model.Item;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CartItem {
    private Item item;
    private int counter;
    private BigDecimal price;

    public CartItem(Item item){
        this.item = item;
        this.counter = 1;
        this.price = item.getPrice();
    }

    public void increaseCounter(){
        counter++;
        recalculate();
    }
    public void decreaseCounter(){
        if (counter > 0) {
            counter--;
            recalculate();
        }
    }

    public boolean hasZeroItems(){
        return counter == 0;
    }

    private void recalculate(){
        price = item.getPrice().multiply(new BigDecimal(counter));
    }

    public boolean idEquals(Item item) {
        return this.item.getId().equals(item.getId());
    }

}
