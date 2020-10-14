package service;

import file.File;
import model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Pattern;

public class ProductMethod implements Method<Product> {
    @Override
    public void add(Product object) {
        ListData.getProducts().add(object);
        File.outPut();
    }

    @Override
    public void delete(int id) {
        for (Product a : ListData.getProducts()) {
            if (id == a.getId()) {
                ListData.getProducts().remove(a);
                File.outPut();
                break;
            }
        }
    }

    @Override
    public ArrayList<Product> seachByName(String name) {
        ArrayList<Product> products = new ArrayList<>();
        for (Product a : ListData.getProducts()) {
            if (Pattern.matches(".*" + name + ".*", a.getName())) {
                products.add(a);
            }
        }
        return products;
    }

    @Override
    public Product seachById(int id) {
        for (Product a : ListData.getProducts()) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public void sortByPriceAscending() {
        // sắp xếp theo giá tăng dần
        Collections.sort(ListData.getProducts(), new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() == o2.getPrice()) {
                    return o1.getId() - o2.getId();
                }
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
    }

    public void sortByPriceDecrease() {
        // sắp xếp theo giá giảm dần
        Collections.sort(ListData.getProducts(), new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() == o2.getPrice()) {
                    return o1.getId() - o2.getId();
                }
                return (int) (o2.getPrice() - o1.getPrice());
            }
        });
    }

    public void sortById() {
        Collections.sort(ListData.getProducts(), new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getId() - o2.getId();
            }
        });
    }

    public void sortByProductShockDiscounts() {
        Collections.sort(ListData.getProducts(), new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getDiscount() == o2.getDiscount()) {
                    return o1.getId() - o2.getId();
                }
                return -(o1.getDiscount() - o2.getDiscount());
            }
        });
    }
}
