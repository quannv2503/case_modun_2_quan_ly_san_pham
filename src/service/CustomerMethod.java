package service;

import file.File;
import model.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Pattern;

public class CustomerMethod implements Method<Customer> {
    @Override
    public void add(Customer object) {
        ListData.getCustomers().add(object);
        File.outPut();
    }


    @Override
    public void delete(int id) {
        for (Customer a : ListData.getCustomers()) {
            if (a.getId() == id) {
                ListData.getCustomers().remove(a);
                File.outPut();
                break;
            }
        }
    }

    @Override
    public ArrayList<Customer> seachByName(String name) {
        ArrayList<Customer> customers = new ArrayList<>();
        for (int i = 0; i < ListData.getCustomers().size(); i++) {
            if (Pattern.matches(".*" + name + ".*", ListData.getCustomers().get(i).getName())) {
                customers.add(ListData.getCustomers().get(i));
            }
        }
        return customers;
    }

    @Override
    public Customer seachById(int id) {
        for (int i = 0; i < ListData.getCustomers().size(); i++) {
            if (id == ListData.getCustomers().get(i).getId()) {
                return ListData.getCustomers().get(i);
            }
        }
        return null;
    }

    public void sortByName() {
        Collections.sort(ListData.getCustomers(), new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                String name1;
                String name2;
                name1 = o1.getName().substring(o1.getName().lastIndexOf(" "));
                name2 = o2.getName().substring(o2.getName().lastIndexOf(" "));
                if (name1.equals(name2)) {
                    return o1.getId() - o2.getId();
                }
                return name1.compareTo(name2);
            }
        });
    }

    public void sortById() {
        Collections.sort(ListData.getCustomers(), new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getId() - o2.getId();
            }
        });
    }
}
