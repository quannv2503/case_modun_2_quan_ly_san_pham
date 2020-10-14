package model;

import java.io.Serializable;

public class Product implements Serializable {
    static private int currentId = 6;
    static private int currentQuantity = 0;
    private int id;
    private String name;
    private double price;
    private int quantity;
    private int discount;
    private double realPrice;

    public Product() {
    }

    public Product(String name, double price, int quantity, int discount) {
        this.id = currentId;
        this.currentId += 1;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        this.realPrice = price - (price * discount) / 100;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.currentQuantity = quantity;
        this.quantity = currentQuantity;

    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(double realPrice) {
        this.realPrice = realPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", discount=" + discount +
                ", realPrice=" + realPrice +
                '}';
    }
}
