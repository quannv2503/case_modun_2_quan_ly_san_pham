package model;

import java.io.Serializable;

public class Evaluate implements Serializable {  // đánh giá
    private Customer customer;
    private int quantityBuy;
    private String comment;

    public Evaluate() {
    }

    public Evaluate(Customer customer, int quantityBuy, String comment) {
        this.customer = customer;
        this.quantityBuy = quantityBuy;
        this.comment = comment;
    }

    public Evaluate(Customer customer, int quantityBuy) {
        this.customer = customer;
        this.quantityBuy = quantityBuy;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getQuantityBuy() {
        return quantityBuy;
    }

    public void setQuantityBuy(int quantityBuy) {
        this.quantityBuy = quantityBuy;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
