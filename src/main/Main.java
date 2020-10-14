package main;

import controller.Bill;
import controller.Statistical;
import file.File;
import model.Customer;
import model.Product;
import service.ListData;
import view.Menu;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
      //  File.outPut();
        ArrayList list = File.inPut();
        ListData.setCustomers((ArrayList<Customer>) list.get(0));
        ListData.setProducts((ArrayList<Product>) list.get(1));
        ListData.setBills((ArrayList<Bill>) list.get(2));
        ListData.setStatisticals((ArrayList<Statistical>) list.get(3));
        Menu menu = new Menu();
        menu.menu();
    }
}
