package product;

import entity.Product;

import java.util.Scanner;

public class ProductFeature {
    public static Product[] products = new Product[100];
    public static int productIndex = 0;

    // Thêm sản phẩm

    public static void addProduct(Scanner scan) {
        System.out.println("Mời nhập vào số sản phẩm muốn thêm:");
        int cntProducts = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < cntProducts; i++) {
            products[productIndex] = new Product();
            products[productIndex].inputProduct(scan);
            productIndex++;
        }
    }

    // Hiển thị thông tin sản phẩm
    public static void displayProducts() {
        for (int i = 0; i < productIndex; i++) {
            products[i].displayData();
        }
    }
    // sắp xếp sản phẩm theo giá

    public static void priceBySort() {
        Product temp = new Product();
        for (int i = 0; i < productIndex; i++) {
            for (int j = 0; j < productIndex - 1 - i; j++) {
                if (products[j].getProductPrice() < products[i].getProductPrice()) {
                     temp = products[j];
                    products[j] = products[j+1];
                    products[j+1] = temp;
                }
            }
        }
        displayProducts();
    }

    //phương thức tìm index
    public static int getIndexById(String productId) {
        for (int i = 0; i < productIndex; i++) {
            if (products[i].getProductId().equals(productId)) {
                return i;
            }
        }
        return -1;
    }

    //Cập nhật sản phẩm
    public static void productUpdate(Scanner scan) {
        System.out.println("Mời nhập vào mã sản phẩm cần cập nhật");
        String updateId = scan.nextLine();
        int updateIndex = getIndexById(updateId);
        if (updateIndex == -1) {
            System.err.println("Mã sản phẩm bạn nhập vào không tồn tại");
        } else {
            // cập nhật
            do {
                System.out.println("*****Cập nhật sản phẩm*****");
                System.out.println("1. Cập nhật tên sản phẩm");
                System.out.println("2.Cập nhật mô tả sản phẩm");
                System.out.println("3. Cập nhật giá sản phẩm");
                System.out.println("4.Cạp nhật trạng thái sản phẩm");
                System.out.println("5. Thoát");
                System.out.println("Mời nhập vào lựa chọn của bạn");
                int choice = Integer.parseInt(scan.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Nhập vào tên mới của sản phẩm");
                        products[updateIndex].setProductName(scan.nextLine());
                        break;
                    case 2:
                        System.out.println("Nhập vào mô tả mới của sản phẩm");
                        products[updateIndex].setProductDescription(scan.nextLine());
                        break;
                    case 3:
                        System.out.println("Nhập vào giá mới của sản phẩm");
                        products[updateIndex].setProductPrice(Float.parseFloat(scan.nextLine()));
                        break;
                    case 4:
                        System.out.println("Nhập vào trạng thái mới của sản phẩm");
                        products[updateIndex].setProductStatus(Integer.parseInt(scan.nextLine()));
                        break;
                    case 5:
                        break;
                    default:
                        System.err.println("Vui lòng nhập lựa chọn từ 1-5");
                }
            } while (true);
        }
    }
    // xóa sản phẩm
    public static void productDelete(Scanner scan) {
        System.out.println("Nhập vào mã sản phẩm muốn xóa");
        String deleteId = scan.nextLine();
        int deleteIndex = getIndexById(deleteId);
        if (deleteIndex == -1) {
            System.err.println("Mã sản phẩm không tồn tại");
        }else {
            //Xóa
            for (int i = 0; i<productIndex; i++) {
                products[i] = products[i+1];

            }
            productIndex--;
        }
    }

    //tìm kiếm sản phẩm theo tên
    public static void productSearch(Scanner scan) {
        System.out.println("Nhập vào tên sản phẩm muốn tìm ");
        String searchPrroductName = scan.nextLine();
        int count = 0;
        for (int i = 0; i < productIndex; i++) {
            if (products[i].getProductName().equalsIgnoreCase(searchPrroductName)) {
                products[i].displayData();
                count++;
            }
        }
        System.out.printf("Tìm thấy %d sản phẩm có %s thỏa mãn ",count,searchPrroductName);
    }
    // tìm kiếm sản phẩm trong khoảng giá tư a-b
    public static   void searchProductPrice(Scanner scan) {
        System.out.println("Mời nhập giá thấp nhất:");
        float startPrice =Float.parseFloat(scan.nextLine());
        System.out.println("Mời nhập giá cao nhất: ");
        float endPrice =Float.parseFloat(scan.nextLine());

        int count = 0;
        for (int i = 0; i < productIndex; i++) {
            if(products[i].getProductPrice()>=startPrice&&products[i].getProductPrice()<=endPrice) {
                products[i].displayData();
                count++;
            }
        }
        System.out.printf("Tìm thấy %d sản phẩm thỏa mãn yêu cầu trong khoảng giá từ %d đến %d",count,startPrice,endPrice);
    }
}

