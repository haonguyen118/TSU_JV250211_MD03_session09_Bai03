package category;

import java.util.Scanner;
public class CategoryManagement {


    public static void menuCategory(Scanner scan) {
            Boolean continues = true;
       while(continues) {
            System.out.println("********CATEGORIES MENU**********");
            System.out.println("1.Nhập thông tin danh mục");
            System.out.println("2. Hien thi thong tin cac danh muc");
            System.out.println("3. Cap nhat thong tin danh muc");
            System.out.println("4. Xoa danh muc");
            System.out.println("5. Cap nhat trang thai danh muc");
            System.out.println("6. Thoat");
            System.out.println(" Moi nhap lua chon cua ban tu 1-6");
            int choice = Integer.parseInt(scan.nextLine());

            switch (choice) {
                case 1:
                    CategoriesFeature.addCategory(scan);
                    break;
                case 2:
                    CategoriesFeature.displayListCategory();
                    break;
                case 3:
                    CategoriesFeature.updateCategory(scan);
                    break;
                case 4:
                    CategoriesFeature.deleteCategory(scan);
                    break;
                case 5:
                    CategoriesFeature.updateCategoryStatus(scan);
                    break;
                case 6:
                    continues = false;
                    break;
                default:
                    System.err.println("Vui long nhap tu 1-6");
            }
        }
    }




}