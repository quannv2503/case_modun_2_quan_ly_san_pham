package model;

import java.io.Serializable;

public class BuyProduct implements Serializable {
    private Product product;
    private int quantityBuy;

    public BuyProduct() {
    }

    public BuyProduct(Product product, int quantityBuy) {
        this.product = product;
        this.quantityBuy = quantityBuy;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantityBuy() {
        return quantityBuy;
    }

    public void setQuantityBuy(int quantityBuy) {
        this.quantityBuy = quantityBuy;
    }
}
