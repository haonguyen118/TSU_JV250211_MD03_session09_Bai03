package category;

import entity.Category;


import java.util.Scanner;


public class CategoriesFeature {
   public static Category[] category = new Category[100];
   public static int categoryIndex = 0;

    public static void displayListCategory() {
        for (int i = 0; i < categoryIndex; i++) {
            category[i].displayData();

        }

    }

    public static void addCategory(Scanner scan) {
        System.out.println("Nhập vào số danh mục muốn thêm");
        int cntCategory = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < cntCategory; i++) {
            category[categoryIndex] = new Category();
            category[categoryIndex].inputCategoryData(scan);
            categoryIndex++;
        }
    }

    public static int getIndexById(int id) {
        for (int i = 0; i < categoryIndex; i++) {
            if(id == category[i].getCatalogId()) {
                return i;
            }
        }
        return -1;
    }


    public static void updateCategory(Scanner scan) {
        System.out.println("Nhap vao ma danh muc muon cap nhat");
        int id = Integer.parseInt(scan.nextLine());
        int indexUpdate = getIndexById(id);
        if (indexUpdate == -1) {
            System.out.println("Mã danh mục nhập vào không tồn tại.");
        } else {
            // cập nhật
            boolean isExist = true;
            do {
                System.out.println("1. Cập nhật tên danh mục");
                System.out.println("2.Cập nhật mô tả danh mục, ");
                System.out.println("3. Cập nhật trạng thái danh mục.");
                System.out.println("4. Thoát");
                System.out.println("Nhập vào lựa chọn của bạn.");
                int choice = Integer.parseInt(scan.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Nhập vào tên danh mục mới");
                        category[indexUpdate].setCatalogName(scan.nextLine());
                        break;
                    case 2:
                        System.out.println("Nhập vào mô tả mới của danh mục");
                        category[indexUpdate].setCatalogDescription(scan.nextLine());
                        break;
                    case 3:
                        System.out.println("Nhập vào trạng thái mới của danh mục");
                        category[indexUpdate].setCatalogStatus(Boolean.parseBoolean(scan.nextLine()));
                        break;
                    case 4:
                        break;
                    default:
                        System.err.println("Vui lòng nhập lựa chọn từ 1-4");
                }
            } while (isExist);
        }
    }



    //xoa danh mục
    public static  void deleteCategory(Scanner scan) {
        System.out.println("Mời nhập vào mã danh mục muốn xóa");
        int deleteId = Integer.parseInt(scan.nextLine());
        int indexDelete = getIndexById(deleteId);
        if (indexDelete == -1) {
            System.err.println("Mã danh mục không tồn tại. Vui lòng nhập lại");
        } else {
            for (int i = indexDelete; i < categoryIndex; i++) {
                category[i] = category[i + 1];

            }
            categoryIndex--;
        }
    }
    public static void updateCategoryStatus(Scanner scan) {
        System.out.println("Mời nhập vào mã danh mục muốn cập nhật");
        int id = Integer.parseInt(scan.nextLine());
        int indexUpdate = -1;
        if(indexUpdate == -1) {
            System.err.println("Mã danh mục không tồn tại");
        }else{
            for (int i = indexUpdate; i < categoryIndex; i++) {
                if(category[i].getCatalogId() == id) {
                    category[i].setCatalogStatus(Boolean.parseBoolean(scan.nextLine()));
                    System.out.println("Đã cập nhật thành công trạng thái danh mục. ");
                }
            }

        }
    }
}

