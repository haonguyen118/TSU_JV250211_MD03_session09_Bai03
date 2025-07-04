package entity;


import business.IShop;
import category.CategoriesFeature;

import java.util.Scanner;

import static java.lang.Boolean.parseBoolean;

public class Category implements IShop {
    private int catalogId;
    private String catalogName;
    private String catalogDescription;
    private Boolean catalogStatus;


    public Category(int catalogId, String catalogName, String catalogDescription, Boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.catalogDescription = catalogDescription;
        this.catalogStatus = catalogStatus;
    }

    public Category() {
    }

    // getter and setter
    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getCatalogDescription() {
        return catalogDescription;
    }

    public void setCatalogDescription(String catalogDescription) {
        this.catalogDescription = catalogDescription;
    }

    public Boolean getCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(Boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }
@Override
public void displayData() {
    System.out.printf("Ma danh muc: %d - Tên danh mục: %s - Mô tả danh mục: %s - Trạng thái danh mục: %s\n", catalogId, catalogName,catalogDescription,catalogStatus?"Đang bán":"Không bán");
}

    public void inputCategoryData(Scanner scan) {
        this.catalogId = inputCatalogId();
        this.catalogName = inputCatalogName(scan);
        this.catalogDescription = inputCatalogDescription(scan);
        this.catalogStatus = inputCatalogStatus(scan);
    }

    // Phương thức kiểm tra mã danh mục
    public int inputCatalogId() {
        if (CategoriesFeature.categoryIndex == 0) {
            return 1;
        } else {
            int maxId = 0;
            for (int i = 0; i < CategoriesFeature.categoryIndex; i++) {
                if (maxId <  CategoriesFeature.category[i].getCatalogId()) {
                    maxId = CategoriesFeature.category[i].getCatalogId();
                }
            }
            return maxId;
        }
    }

    // kiểm tra tên danh mục
    public String inputCatalogName(Scanner scan) {
        System.out.println("Mời nhập vào tên danh mục");
        do {
            String catalogName = scan.nextLine();
            if (catalogName.length() <= 50) {
                boolean isExist = false;
                for (int i = 0; i < CategoriesFeature.categoryIndex; i++) {
                    if ( CategoriesFeature.category[i].getCatalogName().equalsIgnoreCase(catalogName)) {
                        isExist = true;
                        break;
                    }
                }
                if (isExist) {
                    System.err.println("Tên danh mục đã tồn tại, vui lòng nhập lại");
                } else {
                    return catalogName;
                }
            }else{
                System.err.println("Tên danh mục phải bao gồm 1-50 ký tự, vui lòng nhập lại");
            }
        } while (true);
    }


    public String inputCatalogDescription(Scanner scan) {
        System.out.println("Mời nhập vào mô tả danh mục");
        String catalogDescription = scan.nextLine();
        return catalogDescription;
    }
    public Boolean inputCatalogStatus(Scanner scan) {
        System.out.println("Mời nhập trạng thái danh mục (true|false):");
        return Boolean.parseBoolean(scan.nextLine());
    }
}