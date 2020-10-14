package view;

import model.Product;
import service.ListData;
import service.ProductMethod;

import java.util.Scanner;

public class MenuProductManagement {
    // quản lí khách hàng
    public void menuProductManagement() {
        Display display = new Display();
        ProductMethod productMethod = new ProductMethod();
        Scanner scanner = new Scanner(System.in);
        String choice = "0";
        do {
            try {
                System.out.println("                                                Quản lý sản phẩm:");
                System.out.println("<------------------------------------------------------------------------------------------------------------------------->");
                System.out.println("  | 1:Thêm                 |      2:Xoá                  |   3:Tìm kiếm theo id     |    4:Tìm kiếm theo tên              |");
                System.out.println("  | 5:Sắp xếp giá tăng dần |      6:Sắp xếp giá giảm dần |   7:Sắp xếp theo id      |    8:Sắp xếp theo đang giảm giá sốc |");
                System.out.println("                           |      9:Hiển thị danh sách   |   0:Quay lại  ");
                System.out.println("<------------------------------------------------------------------------------------------------------------------------->");

                System.out.print("Bạn chọn:");
                choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        String name;
                        double price;
                        int quantity;
                        int discount;
                        System.out.print("Nhập tên sản phẩm:");
                        name = scanner.nextLine();
                        System.out.print("Nhập giá sản phẩm:");
                        price = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Nhập số lượng:");
                        quantity = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Sản phẩm giảm giá bao nhiêu %:");
                        discount = scanner.nextInt();
                        scanner.nextLine();
                        productMethod.add(new Product(name, price, quantity, discount));
                        break;
                    case "2":
                        System.out.print("Nhập ID sản phẩm bạn muốn xoá:");
                        int deleteName = scanner.nextInt();
                        scanner.nextLine();
                        productMethod.delete(deleteName);
                        break;
                    case "3":
                        System.out.print("Nhập Id sản phẩm bạn muốn tìm kiếm:");
                        int findId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println(productMethod.seachById(findId));
                        break;
                    case "4":
                        System.out.print("Nhập tên sản phẩm bạn muốn tìm kiếm:");
                        String findName = scanner.nextLine();
                        display.disPlayProductSeachByName(productMethod.seachByName(findName));
                        break;
                    case "5":
                        productMethod.sortByPriceAscending();
                        break;
                    case "6":
                        productMethod.sortByPriceDecrease();
                        break;
                    case "7":
                        productMethod.sortById();
                        break;
                    case "8":
                        productMethod.sortByProductShockDiscounts();
                        break;
                    case "9":
                        display.disPlayListProduct(ListData.getProducts());
                    case "0":
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

