package view;

import controller.Bill;
import controller.General;
import controller.Statistical;
import model.BuyProduct;
import model.Customer;
import model.Product;
import service.CustomerMethod;
import service.ListData;
import service.ProductMethod;

import java.util.ArrayList;
import java.util.Scanner;

public class PaymentManagement {
    public void pay() {
        ArrayList<Customer> customers = ListData.getCustomers();
        ArrayList<Product> products = ListData.getProducts();
        ArrayList<Bill> bills = ListData.getBills();
        ArrayList<Statistical> statisticals = ListData.getStatisticals();
        General general = new General();
        Display display = new Display();
        CustomerMethod customerMethod = new CustomerMethod();
        ProductMethod productMethod = new ProductMethod();
        MenuCustomerManagement menuCustomerManagement = new MenuCustomerManagement();
        MenuProductManagement menuProductManagement = new MenuProductManagement();

        ArrayList<BuyProduct> buyProducts = new ArrayList<>();
        Customer customer;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên khách hàng:");
        String nameCustomer = scanner.nextLine();
        customer = display.findBillingCustomerName((customerMethod.seachByName(nameCustomer)));
        if (customer == null) return;
        String choice = "0";
        do {
            System.out.print("Nhập tên sản phẩm:");
            String nameProduct = scanner.nextLine();
            Product product;
            product = display.findBillingProductName(productMethod.seachByName(nameProduct));
            // khi mua thêm cùng 1 sp sẽ bị lỗi số sản phẩm còn lại
            if (product == null) return;
            System.out.print("Nhập số lượng muốn mua:");
            int quantityBuy = scanner.nextInt();
            scanner.nextLine();
            buyProducts.add(new BuyProduct(product, quantityBuy));
            System.out.println("1:tiếp tục mua   |     0:thanh toán");
            System.out.print("Bạn chọn:");
            choice = scanner.nextLine();
        } while (choice.equals("1"));
        System.out.println("Mời bạn thanh toán:" + general.pay(customer, buyProducts) + "VNĐ");
        System.out.println("Sau khi đã mua sản phẩm bạn có lời đánh giá gì không ?");
        System.out.println("1:Có      |       2:Không");
        System.out.print("Bạn nhập:");
        String choice1 = scanner.nextLine();
        if (choice1.equals("1")) {
            for (int i = 0; i < buyProducts.size(); i++) {
                System.out.print("Ý kiến về sản phẩm " + buyProducts.get(i).getProduct().getName() + ":");
                String comment = scanner.nextLine();
                general.comment(comment, buyProducts.get(i).getProduct().getId(), customer.getId());
            }
        }
    }

}
