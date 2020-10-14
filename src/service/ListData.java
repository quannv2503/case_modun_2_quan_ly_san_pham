package service;

import controller.Bill;
import controller.Statistical;
import model.BuyProduct;
import model.Customer;
import model.Evaluate;
import model.Product;

import java.util.ArrayList;

public class ListData {
    static private ArrayList<Customer> customers = new ArrayList<>();
    static private ArrayList<Product> products = new ArrayList<>();
    static private ArrayList<Bill> bills = new ArrayList<>();
    static private ArrayList<Statistical> statisticals = new ArrayList<>();

//    static {
//        customers.add(new Customer("nguyen van quan", "ha noi", "0123456789"));
//        customers.add(new Customer("nguyen quoc anh", "ca mau", "0987654321"));
//        customers.add(new Customer("nguyen thi ngoc anh", "ha noi", "0123123123"));
//        customers.add(new Customer("trần duc bo", "ha noi", "0123451234"));
//        customers.add(new Customer("nguyen the anh", "hai phong", "0923344444"));
//        customers.add(new Customer("vu thi hoa", "thanh hoa", "0167874041"));
//
//        products.add(new Product("iphone5", 3000, 15, 0));
//        products.add(new Product("ipad_gen5", 4000, 4, 0));
//        products.add(new Product("ipad_gen9", 9000, 10, 20));
//        products.add(new Product("macbook2020", 15000, 8, 10));
//        products.add(new Product("may giat", 10000, 20, 0));
//        products.add(new Product("tu lanh", 8000, 40, 30));
//
//        ArrayList<BuyProduct> buyProducts = new ArrayList<>();
//        buyProducts.add(new BuyProduct(products.get(0), 1));
//        buyProducts.add(new BuyProduct(products.get(2), 2));
//        bills.add(new Bill(customers.get(0), buyProducts));
//
//
//        ArrayList<Evaluate> evaluates = new ArrayList<>();
//        evaluates.add(new Evaluate(customers.get(2), 1, "tốt quá"));
//        statisticals.add(new Statistical(products.get(0), evaluates));
//
//    }


    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(ArrayList<Customer> customers) {
        ListData.customers = customers;
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static void setProducts(ArrayList<Product> products) {
        ListData.products = products;
    }

    public static ArrayList<Bill> getBills() {
        return bills;
    }

    public static void setBills(ArrayList<Bill> bills) {
        ListData.bills = bills;
    }

    public static ArrayList<Statistical> getStatisticals() {
        return statisticals;
    }

    public static void setStatisticals(ArrayList<Statistical> statisticals) {
        ListData.statisticals = statisticals;
    }
}