package view;

import controller.Bill;
import controller.Statistical;
import model.Customer;
import model.Product;
import service.ListData;

import java.util.ArrayList;
import java.util.Scanner;

public class Display {
    private ArrayList<Customer> customers = ListData.getCustomers();
    private ArrayList<Product> products = ListData.getProducts();
    private ArrayList<Bill> bills = ListData.getBills();
    private ArrayList<Statistical> statisticals = ListData.getStatisticals();
    Scanner scanner = new Scanner(System.in);

    public void disPlayListProduct(ArrayList<Product> arrayList) {
        ArrayList<Customer> customers = ListData.getCustomers();
        ArrayList<Product> products = ListData.getProducts();
        ArrayList<Bill> bills = ListData.getBills();
        ArrayList<Statistical> statisticals = ListData.getStatisticals();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("id:" + arrayList.get(i).getId() + " ten:" + arrayList.get(i).getName() +
                    " gia:" + arrayList.get(i).getPrice() + " so lương:" + arrayList.get(i).getQuantity()
                    + " giảm giá tới:" + arrayList.get(i).getDiscount() + "%");
        }
    }

    public void disPlayListStatistical() {
        System.out.println("      <-----------------------------Danh sách sản phẩm------------------------------->");
        System.out.printf("\t%7s %15s %23s %20s %15s\n\n", "STT", "ID", "Tên", "Giá", "Giảm giá");
        for (int i = 0; i < ListData.getStatisticals().size(); i++) {
            System.out.printf("\t\t %-15d %-22s %-19s %-13s %-5s \n", (i + 1), statisticals.get(i).getProduct().getId(), statisticals.get(i).getProduct().getName(),
                    statisticals.get(i).getProduct().getPrice(), statisticals.get(i).getProduct().getDiscount() + "%");
        }
    }

    public void disPlayListBill(ArrayList<Bill> bills) {
        for (int i = 0; i < bills.size(); i++) {
            for (int j = 0; j < bills.get(i).getBuyProducts().size(); j++) {
                System.out.println(" id khacg hang " + ListData.getBills().get(i).getCustomer().getId() + " ten :" + ListData.getBills().get(i).getCustomer().getName()
                        + " so luong còn laji: " + ListData.getBills().get(i).getBuyProducts().get(j).getProduct().getQuantity() + " số lượng mua " + ListData.getBills().get(i).getBuyProducts().get(j).getQuantityBuy()
                        + " tên san pham  " + ListData.getBills().get(i).getBuyProducts().get(j).getProduct().getName() + "id san pham :"
                        + ListData.getBills().get(i).getBuyProducts().get(j).getProduct().getId());
            }
        }

    }

    public void disPlayCustomer() {
        System.out.println("      <-----------------------------Danh sách khách hàng---------------------------->");
        System.out.printf("\t%7s %15s %35s %20s \n\n", "ID", "Tên", "SĐT", "Địa chỉ");
        for (int i = 0; i < customers.size(); i++) {
            System.out.printf("\t\t %-14d %-35s %-16s %-5s \n", customers.get(i).getId(), customers.get(i).getName(), customers.get(i).getPhoneNumber(), customers.get(i).getAddress());
        }
    }

    public void disPlayCustomerSeachByName(ArrayList<Customer> list) {
        if (list.isEmpty()) {
            System.out.println("Không tìm thấy!");
        } else if (list.size() == 1) {
            System.out.println("Thông tin khách hàng bạn tìm thấy:" + list.get(0));
        } else {
            System.out.println("Tìm kiếm được:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ":" + list.get(i).getName());
            }
            System.out.print("Tìm theo STT bạn thấy:");
            int find = Integer.parseInt(scanner.nextLine());
            System.out.println("Thông tin khách hàng bạn muốn tìm:" + list.get(find - 1));

        }
    }


    public void disPlayProductSeachByName(ArrayList<Product> list) {
        if (list.isEmpty()) {
            System.out.println("Không tìm thấy!");
        } else if (list.size() == 1) {
            System.out.println("Thông tin sản phẩm bạn tìm thấy:" + list.get(0));
        } else {
            System.out.println("Tìm kiếm được:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ":" + list.get(i).getName());
            }
            System.out.print("Tìm theo STT bạn thấy:");
            int find = Integer.parseInt(scanner.nextLine());
            System.out.println("Thông tin khách hàng bạn muốn tìm:" + list.get(find - 1));

        }
    }

    public Customer findBillingCustomerName(ArrayList<Customer> list) {
        // tìm tên khách hàng muốn thanh toán
        if (list.isEmpty()) {
            System.out.println("Không tìm thấy!");
        } else if (list.size() == 1) {
            System.out.println("Khách hàng:" + list.get(0).getName());
            return list.get(0);
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ":" + list.get(i).getName() + "   với id:" + list.get(i).getId());
            }
            System.out.print("Chọn theo stt:");
            int find = Integer.parseInt(scanner.nextLine());
            System.out.println("Khách hàng:" + list.get(find - 1).getName());
            return list.get(find - 1);
        }
        return null;
    }

    public Product findBillingProductName(ArrayList<Product> list) {
        // tìm tên sản phẩm muốn thanh toán
        if (list.isEmpty()) {
            System.out.println("Không tìm thấy!");
        } else if (list.size() == 1) {
            System.out.println("Tên sản phẩm:" + list.get(0).getName());
            return list.get(0);
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ":" + list.get(i).getName() + "   với id:" + list.get(i).getId());
            }
            System.out.print("Chọn theo stt:");
            int find = Integer.parseInt(scanner.nextLine());
            System.out.println("Đã chọn sản phẩm:" + list.get(find - 1).getName() + "   | Với giá:" + list.get(find - 1).getRealPrice() + "VNĐ  " + "|   còn với số lượng:" + list.get(find - 1).getQuantity());
            return list.get(find - 1);
        }
        return null;
    }

    public Statistical SeeDetails() {
        System.out.print("Xem theo STT bạn thấy:");
        int find = Integer.parseInt(scanner.nextLine());
        return ListData.getStatisticals().get(find - 1);
    }

    public void DisplayCustomerStatistics(Statistical statistical) {
        // hiển thi thông tin các khách hàng đã mua sản phẩm đó
        System.out.println("Sản phẩm :" + statistical.getProduct().getName());
        for (int i = 0; i < statistical.getEvaluates().size(); i++) {
            if (statistical.getEvaluates().get(i).getComment() == null) {
                System.out.println("Tên:" + statistical.getEvaluates().get(i).getCustomer().getName()
                        + "      |     đã mua:" + statistical.getEvaluates().get(i).getQuantityBuy() + "sp");
            } else {
                System.out.println("Tên:" + statistical.getEvaluates().get(i).getCustomer().getName()
                        + "      |     Đã mua:" + statistical.getEvaluates().get(i).getQuantityBuy() + "sp" + "     |      Đánh giá:" +
                        statistical.getEvaluates().get(i).getComment());
            }
        }
    }


}

