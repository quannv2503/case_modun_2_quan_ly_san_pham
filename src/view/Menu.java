package view;

import controller.Bill;
import controller.General;
import controller.Statistical;
import model.Customer;
import model.Product;
import service.CustomerMethod;
import service.ListData;
import service.ProductMethod;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    MenuCustomerManagement menuCustomerManagement = new MenuCustomerManagement();
    MenuProductManagement menuProductManagement = new MenuProductManagement();
    PaymentManagement paymentManagement = new PaymentManagement();
    StatisticsOfProductsSold statisticsOfProductsSold = new StatisticsOfProductsSold();
    Scanner scanner = new Scanner(System.in);

    public void menu() {
        do {
            try {
                System.out.println();
                System.out.println("                                                Please select menu:");
                System.out.println("<------------------------------------------------------------------------------------------------------------------------->");
                System.out.println();
                System.out.println("  |           1:Quản lý khách hàng                   |                        2:Quản lý sản phẩm                    |");
                System.out.println("  |           3:Quản lý thanh toán                   |                        4:Thống kê sản phẩm bán được          |");
                System.out.println("                                                   0:Exit    ");
                System.out.println("<------------------------------------------------------------------------------------------------------------------------->");

                System.out.print("Bạn chọn:");
                switch (scanner.nextLine()) {
                    case "1":
                        menuCustomerManagement.menuCustomerManagement();
                        break;
                    case "2":
                        menuProductManagement.menuProductManagement();
                        break;
                    case "3":
                        paymentManagement.pay();
                        break;
                    case "4":
                        statisticsOfProductsSold.statisticsOfProductsSold();
                        break;
                    case "0":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Retype!");
                }
            } catch (Exception e) {
                System.out.println("Retype!");
            }
        } while (true);
    }
}
