package view;

import model.Customer;
import service.CustomerMethod;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuCustomerManagement {
    // quản lý khách hàng
    Display display = new Display();
    CustomerMethod customerMethod = new CustomerMethod();
    Scanner scanner = new Scanner(System.in);

    public void menuCustomerManagement() {
        String choice = "0";
        do {
            try {
                System.out.println("                                                Quản lý khách hàng:");
                System.out.println("<------------------------------------------------------------------------------------------------------------------------->");
                System.out.println("       | 1:Thêm             |        2:Xoá             |          3:Tìm kiếm theo id      |     4:Tìm kiếm theo tên    |");
                System.out.println("       | 5:Sắp xếp theo tên |        6:Sắp xếp theo Id |          7:Hiểm thị danh sách    |     0:Quay lại             |                            |");
                System.out.println("<------------------------------------------------------------------------------------------------------------------------->");

                System.out.print("Bạn chọn:");
                choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        boolean validName = false;
                        String name;
                        do {
                            System.out.print("Nhập tên:");
                            name = scanner.nextLine();
                            String regexName = "^[a-zA-Z\\sàáạã_-]{3,25}$";
                            Pattern pattern = Pattern.compile(regexName);
                            Matcher matcher = pattern.matcher(name);
                            if (matcher.find()) {
                                validName = true;
                                break;
                            } else {
                                System.out.println("Tên không hợp lệ!");
                            }
                        } while (!validName);
                        System.out.print("Nhập địa chỉ:");
                        String address = scanner.nextLine();
                        boolean validNumber = false;
                        String phoneNumber;
                        do {
                            System.out.print("\nNhập SĐT:");
                            phoneNumber = scanner.nextLine();
                            String regexPhoneNumber = "^\\+?(?:0|84)(?:\\d){9}$";

                            Pattern pattern = Pattern.compile(regexPhoneNumber);
                            Matcher matcher = pattern.matcher(phoneNumber);
                            if (matcher.find()) {
                                validNumber = true;
                                break;
                            } else {
                                System.out.println("SĐT không hợp lệ!");
                            }
                        } while (!validNumber);
                        customerMethod.add(new Customer(name, address, phoneNumber));
                        break;
                    case "2":
                        System.out.print("Nhập ID khách hàng bạn muốn xoá:");
                        int deleteName = scanner.nextInt();
                        scanner.nextLine();
                        customerMethod.delete(deleteName);
                        break;
                    case "3":
                        System.out.print("Nhập Id khách hàng bạn muốn tìm kiếm:");
                        int findId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println(customerMethod.seachById(findId));
                        break;
                    case "4":
                        System.out.print("Nhập tên khách hàng bạn muốn tìm kiếm:");
                        String findName = scanner.nextLine();
                        display.disPlayCustomerSeachByName(customerMethod.seachByName(findName));
                        break;
                    case "5":
                        customerMethod.sortByName();
                        break;
                    case "6":
                        customerMethod.sortById();
                        break;
                    case "7":
                        display.disPlayCustomer();
                        break;
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
