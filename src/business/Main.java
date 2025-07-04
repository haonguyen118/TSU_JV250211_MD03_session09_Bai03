package business;



import category.CategoryManagement;
import product.ProductManagement;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("**********SHOP MENU**********");
            System.out.println("1. Quan ly danh muc san pham");
            System.out.println("2. Quan ly san pham");
            System.out.println("3.Thoat");
            System.out.println("Moi nhap lua chon cua ban tu 1-3");
            int choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:
                    CategoryManagement.menuCategory(scan);
                    break;
                case 2:
                   ProductManagement.menuProduct(scan);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("Vui long chon tu 1-3");
            }

        } while (true);

    }
}