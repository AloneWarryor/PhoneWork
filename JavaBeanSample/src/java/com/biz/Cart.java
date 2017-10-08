/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biz;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    //  a list of CartItem
    private List<CartItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    //  add a cartitem to cart
    public void addCartItem(CartItem ci) {
        for (CartItem x : items) {
            if (x.getId() == ci.getId()) {
                x.setQuantity(x.getQuantity() + 1);
                return;
            }
        }

        items.add(ci);
    }

    //  get total amount of cart
    public double getAmount() {
        double t = 0;
        for (CartItem x : items) {
            t += x.getAmount();
        }

        return t;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }    
}