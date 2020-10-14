package controller;

import model.BuyProduct;
import model.Customer;

import java.io.Serializable;
import java.util.ArrayList;

public class Bill implements Serializable { // hoá đơn
    private Customer customer;
    private ArrayList<BuyProduct> buyProducts;

    public Bill(Customer customer, ArrayList<BuyProduct> buyProducts) {
        this.customer = customer;
        this.buyProducts = buyProducts;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<BuyProduct> getBuyProducts() {
        return buyProducts;
    }

    public void setBuyProducts(ArrayList<BuyProduct> buyProducts) {
        this.buyProducts = buyProducts;
    }
}