package view;

import controller.General;

import java.util.Scanner;

public class StatisticsOfProductsSold {
    // thống kê các sản phẩm đã bán được
    public void statisticsOfProductsSold() {
        General general = new General();
        Display display = new Display();
        Scanner scanner = new Scanner(System.in);
        String choice = "0";
        do {
            try {
                System.out.println("                                             Bảng xếp hạng sản phẩm đã bán theo:");
                System.out.println("<------------------------------------------------------------------------------------------------------------------------->");
                System.out.println("     | 1:Số lượng sản phẩm bán ra nhiều               |                 2:Sản phẩm có doanh thu nhiều          |");
                System.out.println("     | 3:Sản phẩm có nhiều đánh giá                   |                 4:Sản phẩm đang có giá giảm sốc        |");
                System.out.println("                                                 0:Quay lại  ");
                System.out.println("<------------------------------------------------------------------------------------------------------------------------->");

                System.out.print("Bạn chọn:");
                choice = scanner.nextLine();
                switch (choice) {
                    case "0":
                        break;
                    case "1":
                        general.statisticsByTheNumberOfSale();
                        String choice1;
                        do {
                            display.disPlayListStatistical();
                            System.out.println("0:Quay lại  |   1:Xem chi tiết");
                            System.out.print("Bạn chọn:");
                            choice1 = scanner.nextLine();
                            if (choice1.equals("1")) {
                                display.DisplayCustomerStatistics(display.SeeDetails());
                            }
                        } while (!choice1.equals("0"));
                        break;
                    case "2":
                        general.statisticsByProfitableProduct();
                        String choice2;
                        do {
                            display.disPlayListStatistical();
                            System.out.println("0:Quay lại  |   1:Xem chi tiết");
                            System.out.print("Bạn chọn:");
                            choice2 = scanner.nextLine();
                            if (choice2.equals("1")) {
                                display.DisplayCustomerStatistics(display.SeeDetails());
                            }
                        } while (!choice2.equals("0"));
                        break;
                    case "3":
                        general.statisticsAccordingToCustomerReviews();
                        String choice3;
                        do {
                            display.disPlayListStatistical();
                            System.out.println("0:Quay lại  |   1:Xem chi tiết");
                            System.out.print("Bạn chọn:");
                            choice3 = scanner.nextLine();
                            if (choice3.equals("1")) {
                                display.DisplayCustomerStatistics(display.SeeDetails());
                            }
                        } while (!choice3.equals("0"));
                        break;
                    case "4":
                        general.statisticsByProductShockDiscounts();
                        String choice4;
                        do {
                            display.disPlayListStatistical();
                            System.out.println("0:Quay lại  |   1:Xem chi tiết");
                            System.out.print("Bạn chọn:");
                            choice4 = scanner.nextLine();
                            if (choice4.equals("1")) {
                                display.DisplayCustomerStatistics(display.SeeDetails());
                            }
                        } while (!choice4.equals("0"));
                        break;
                    default:
                        System.out.println("Retype!");
                }
            } catch (
                    Exception e) {
                System.out.println("Retype!");
            }
        } while (!choice.equals("0"));
    }
}

