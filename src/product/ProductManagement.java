package product;



import entity.Product;

import java.util.Scanner;

public class ProductManagement {



    public static void menuProduct(Scanner scan) {
        Boolean continues = true;
        while ( continues){
            System.out.println("********PRODUCT MANAGEMENT*********");
            System.out.println("1. Nhap thong tin san pham");
            System.out.println(" 2. Hien thi thong tin cac san pham");
            System.out.println("3.Sắp xếp các sản phẩm theo giá");
            System.out.println(" 4. Cap nhat thong tin san pham theo ma danh muc ");
            System.out.println("5. Xoa san pham theo ma san pham");
            System.out.println("6. Tim kiem cac san pham theo ten san pham");
            System.out.println("7. Tim kiem san pham trong khoang gia a-b (a va b nhap tu san pham");
            System.out.println("8. Thoat");
            System.out.println("Nhap lua chon cua ban tu 1-8");
            int choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:
                    ProductFeature.addProduct(scan);
                    break;
                case 2:
                    ProductFeature.displayProducts();
                    break;
                case 3:
                    ProductFeature.priceBySort();
                    break;
                case 4:
                    ProductFeature.productUpdate(scan);
                    break;
                case 5:
                    ProductFeature.productDelete(scan);
                    break;
                case 6:
                    ProductFeature.productSearch(scan);
                    break;
                case 7:
                    ProductFeature.searchProductPrice(scan);
                    break;
                case 8:
                    continues = false;
                    break;
                default:
                    System.err.println("Vui long nhap tu 1-8");
            }
        }
    }
}
