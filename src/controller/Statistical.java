package controller;

import model.Evaluate;
import model.Product;

import java.io.Serializable;
import java.util.ArrayList;

public class Statistical implements Serializable {
    private Product product;
    ArrayList<Evaluate> evaluates = new ArrayList<>();

    public Statistical() {
    }

    public Statistical(Product product, ArrayList<Evaluate> evaluates) {
        this.product = product;
        this.evaluates = evaluates;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ArrayList<Evaluate> getEvaluates() {
        return evaluates;
    }

    public void setEvaluates(ArrayList<Evaluate> evaluates) {
        this.evaluates = evaluates;
    }
}
