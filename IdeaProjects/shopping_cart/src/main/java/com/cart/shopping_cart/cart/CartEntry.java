package com.cart.shopping_cart.cart;
import com.cart.shopping_cart.home.Product;

public class CartEntry {
    public Product product;
    public int quantity;

    public CartEntry(Product product,int quantity) {
        this.product = product;
        this.quantity = quantity;

    }
    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    public void increaseQuantity(){
        this.quantity++;
    }

    public void decreaseQuantity(){
        if(this.quantity>0){
            this.quantity--;
        }
    }
}
