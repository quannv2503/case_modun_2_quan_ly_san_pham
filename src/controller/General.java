package controller;

import file.File;
import model.BuyProduct;
import model.Customer;
import model.Evaluate;
import model.Product;
import service.ListData;

import java.util.*;

public class General {
    public double pay(Customer customer, ArrayList<BuyProduct> buyProducts) {
        double sum = 0;
        for (int i = 0; i < buyProducts.size(); i++) {
            // thực hiện mua từng sảm phẩm nếu còn sản pham
            if (buyProducts.get(i).getQuantityBuy() <= buyProducts.get(i).getProduct().getQuantity() && buyProducts.get(i).getQuantityBuy() > 0) {
                // thực hiện thanh toán
                sum += buyProducts.get(i).getProduct().getRealPrice() * buyProducts.get(i).getQuantityBuy();
                // thực hiện sản số lượng sảm phẩm khi mua được
                for (int j = 0; j < ListData.getProducts().size(); j++) {
                    if (buyProducts.get(i).getProduct().getId() == ListData.getProducts().get(j).getId()) {
                        ListData.getProducts().get(j).setQuantity(ListData.getProducts().get(j).getQuantity() - buyProducts.get(i).getQuantityBuy());
                        break;
                    }
                }
            } else {
                // không khoả mãn xoá ra khỏi hoá đơn
                buyProducts.remove(buyProducts.get(i));
                i--;
            }
        }
        // in hoá đơn khi khách hàng mua
        if (sum > 0) {
            // thêm hoá đơn vào danh sách
            addBill(customer, buyProducts);
            File.outPut();
        }
        return sum;
    }

    // thêm hoá đơn
    private void addBill(Customer customer, ArrayList<BuyProduct> buyProducts) {
        ListData.getBills().add(new Bill(customer, buyProducts));
        convertInvoicesIntoItatistics(customer, buyProducts);
    }

    // thêm vào danh sách thống kee
    private void addStatistical(Product product, ArrayList<Evaluate> evaluates) {
        ListData.getStatisticals().add(new Statistical(product, evaluates));
    }

    private void convertInvoicesIntoItatistics(Customer customer, ArrayList<BuyProduct> buyProducts) {
        // chuyển từ hoa đơn sang thống kê
        for (int i = 0; i < buyProducts.size(); i++) {
            boolean isHas = true;
            if (i == 0 && ListData.getStatisticals() == null) {
                ArrayList<Evaluate> evaluates = new ArrayList<>();
                evaluates.add(new Evaluate(customer, buyProducts.get(i).getQuantityBuy()));
                addStatistical(buyProducts.get(0).getProduct(), evaluates);
            } else {
                // kiểm tra xem sản phẩm đó có trong list chưa
                for (int j = 0; j < ListData.getStatisticals().size(); j++) {
                    // nếu có rồi
                    if (buyProducts.get(i).getProduct().getId() == ListData.getStatisticals().get(j).getProduct().getId()) {
                        ListData.getStatisticals().get(j).getEvaluates().add(new Evaluate(customer, buyProducts.get(i).getQuantityBuy()));
                        isHas = false;
                        break;
                    }

                }
                // nếu chưa có
                if (isHas) {
                    ArrayList<Evaluate> evaluates = new ArrayList<>();
                    evaluates.add(new Evaluate(customer, buyProducts.get(i).getQuantityBuy()));
                    addStatistical(buyProducts.get(i).getProduct(), evaluates);
                }
            }
        }

    }

    public void comment(String comment, int idProduct, int idCustomer) {
        if (comment.equals("") || comment.equals(" ") || comment.equals("  ")) {
            // xử lí lại
            return;
        }
        for (int i = 0; i < ListData.getStatisticals().size(); i++) {
            if (ListData.getStatisticals().get(i).getProduct().getId() == idProduct) {
                for (int j = 0; j < ListData.getStatisticals().get(i).getEvaluates().size(); j++) {
                    if (ListData.getStatisticals().get(i).getEvaluates().get(j).getCustomer().getId() == idCustomer) {
                        if (ListData.getStatisticals().get(i).getEvaluates().get(j).getComment() == null) {
                            ListData.getStatisticals().get(i).getEvaluates().get(j).setComment(comment);
                        } else {
                            String commentBefore = ListData.getStatisticals().get(i).getEvaluates().get(j).getComment();
                            ListData.getStatisticals().get(i).getEvaluates().get(j).setComment(commentBefore + comment);
                        }
                        break;
                    }

                }
                break;
            }
        }
    }

    public void statisticsByTheNumberOfSale() {
        // sắp xếp theo so lượng sản phẩm bán ra
        Collections.sort(ListData.getStatisticals(), new Comparator<Statistical>() {
            @Override
            public int compare(Statistical o1, Statistical o2) {
                int sum1 = 0;
                for (Evaluate evaluate : o1.getEvaluates()) {
                    sum1 += evaluate.getQuantityBuy();
                }
                int sum2 = 0;
                for (Evaluate evaluate : o2.getEvaluates()) {
                    sum2 += evaluate.getQuantityBuy();
                }
                if (sum1 == sum2) {
                    return o1.getProduct().getId() - o2.getProduct().getId();
                }
                return -(sum1 - sum2);
            }
        });
    }

    public void statisticsByProfitableProduct() {
        // sắp xếp sản phẩm theo danh thu
        Collections.sort(ListData.getStatisticals(), new Comparator<Statistical>() {
            @Override
            public int compare(Statistical o1, Statistical o2) {
                int sum1 = 0;
                double revenue1 = 0;// doanh thu
                for (Evaluate evaluate : o1.getEvaluates()) {
                    sum1 += evaluate.getQuantityBuy();
                }
                revenue1 = sum1 * o1.getProduct().getRealPrice();
                int sum2 = 0;
                double revenue2 = 0;// doanh thu
                for (Evaluate evaluate : o2.getEvaluates()) {
                    sum2 += evaluate.getQuantityBuy();
                }
                revenue2 = sum2 * o2.getProduct().getRealPrice();
                if (revenue1 == revenue2) {
                    return o1.getProduct().getId() - o2.getProduct().getId();
                }
                return (int) -(revenue1 - revenue2);
            }
        });
    }

    public void statisticsAccordingToCustomerReviews() {
        // sắp xếp theo lượt đánh giá
        Collections.sort(ListData.getStatisticals(), new Comparator<Statistical>() {
            @Override
            public int compare(Statistical o1, Statistical o2) {
                int sum1 = 0; // số lần bình luận
                for (Evaluate evaluate : o1.getEvaluates()) {
                    if (evaluate.getComment() != null) {
                        sum1++;
                    }
                }
                int sum2 = 0;
                for (Evaluate evaluate : o2.getEvaluates()) {
                    if (evaluate.getComment() != null) {
                        sum2++;
                    }
                }
                if (sum1 == sum2) {
                    return o1.getProduct().getId() - o2.getProduct().getId();
                }
                return -(sum1 - sum2);
            }
        });
    }

    public void statisticsByProductShockDiscounts() {
        // theo đang giảm giá sốc
        Collections.sort(ListData.getStatisticals(), new Comparator<Statistical>() {
            @Override
            public int compare(Statistical o1, Statistical o2) {
                int discountProducts1 = o1.getProduct().getDiscount(); // san phẩm giảm giá 1
                int discountProducts2 = o2.getProduct().getDiscount();
                if (discountProducts1 == discountProducts2) {
                    return o1.getProduct().getId() - o2.getProduct().getId();
                }
                return -(discountProducts1 - discountProducts2);
            }
        });

    }
}
