package entity;



import business.IShop;
import category.CategoriesFeature;
import product.ProductFeature;

import java.util.Scanner;
import java.util.regex.Pattern;



public class Product implements IShop {
    private String productId;
    private String productName;
    private String productDescription;
    private float productPrice;
    private int productStatus;
    private int catalogId;


//    public void Product() {
//
//    }

    public void Product(String productId, String productName, String productDescription, float productPrice, int productStatus, int catelogId) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productStatus = productStatus;
        this.catalogId = catalogId;
    }

   public void setProductId(String productId) {
        this.productId = productId;
    }

   public void setProductName(String productName) {
        this.productName = productName;
    }

   public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

   public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

   public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

   public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }


    //getter

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public int getCategoryId() {
        return catalogId;
    }


    @Override
    public void displayData() {
        System.out.printf("Ma san pham: %s, Ten: %s, mo ta: %s, gia: %f, trang thai: %s, danh mục: %s\n", productId, productName, productDescription, productPrice, productStatus == 0 ? "Đang bán" : (productStatus == 1 ? "Hết hàng" : "Không bán"), getCatalogNameById(catalogId));
    }

    public void inputProduct(Scanner scan) {
        this.productId = inputProductId(scan);
        this.productName = inputProductName(scan);
        this.productDescription = inputProductDecription(scan);
        this.productPrice = inputProductPrice(scan);
        this.productStatus = inputProductStatus(scan);
        this.catalogId = inputCatalogId(scan);
    }

    // phương thức kiểm tra mã sản phẩm
    public String inputProductId(Scanner scan) {
        System.out.println("Nhap ma san pham (S001/C001/A001): ");
        String productIdRegex = "[ACS]\\%d{3}";
        do {
            String productId = scan.nextLine();
            if (productId.matches(productIdRegex)) {
                boolean isExist = false;

                for (int i = 0; i < ProductFeature.productIndex; i++) {
                    if (ProductFeature.products[i].getProductId().equalsIgnoreCase(productId)) {
                        isExist = true;
                        break;
                    }

                }
                if (isExist) {
                    System.err.println("Mã sản phẩm đã tồn tại. Vui lòng nhập lại.");
                } else {
                    return this.productId;
                }
            } else {
                System.err.println("Mã sản phẩm bao gồm 4 ký tự, bắt đầu từ ký tự A | C | S, 3 ký tự sau là số");
            }
        } while (true);
    }

    //phương thức kiểm tra tên sản phẩm
    public String inputProductName(Scanner scan) {
        System.out.println("Mời nhập tên sản phẩm");
        do {
            String productName = scan.nextLine();
            if (productName.length() >= 10 && productName.length() <= 50) {
                boolean isExist = false;
                for (int i = 0; i < ProductFeature.productIndex; i++) {
                    if (ProductFeature.products[i].getProductName().equalsIgnoreCase(productName)) {
                        isExist = true;
                        break;
                    }

                }
                if (isExist) {
                    System.err.println("Tên sản phẩm đã tồn tại");
                } else {
                    return this.productName;
                }
            } else {
                System.err.println("Tên sản phẩm phải có 10-50 ký tự, vui lòng nhập lại.");
            }
        }
        while (true);
    }

    public float inputProductPrice(Scanner scan) {
        System.out.println("Mời nhập giá sản phẩm");
        do {
            float productPrice = Float.parseFloat(scan.nextLine());
            if (productPrice >= 0) {
                return productPrice;
            } else {
                System.err.println("Giá của sản phẩm phải là số dương.Vui lòng nhập lai.");
            }
        } while (true);
    }

    // phương thức nhập mô tả sản phẩm
    public String inputProductDecription(Scanner scan) {
        System.out.println("Mời nhập vào mô tả sản phẩm:");
        String productDescription = scan.nextLine();
        return productDescription;
    }

    //phương thức nhập trạng thái sản phẩm
    public int inputProductStatus(Scanner scan) {
        System.out.println("Mời nhập trạng thái sản phẩm: 0- đang bán, 1- hết hàng, 2- không bán.");
        int productStatus = Integer.parseInt(scan.nextLine());
        if (productStatus == 0 || productStatus == 1 || productStatus == 2) {
            return productStatus;
        } else {
            System.err.println("Nhập trạng thái không đúng. vui lòng nhập lại; 0- đang bán, 1- hết hàng, 2- không bán.");
            return productStatus;
        }

    }

    public int inputCatalogId(Scanner scan) {
        int catalogId = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < CategoriesFeature.category[i].getCatalogId();i++) {
            if (CategoriesFeature.category[i].getCatalogId() == catalogId) {
                catalogId = CategoriesFeature.category[i].getCatalogId();
                return catalogId;
            } else {
                System.err.println("Mã danh mục không tồn tại. Vui lòng nhập lại");
            }
        }
        return -1;
    }


    public String getCatalogNameById(int catalogId) {
        for (int i = 0; i < CategoriesFeature.categoryIndex; i++) {
            if (CategoriesFeature.category[i].getCatalogId() == catalogId) {
                return CategoriesFeature.category[i].getCatalogName();
            }
        }
        return null;
    }
}

