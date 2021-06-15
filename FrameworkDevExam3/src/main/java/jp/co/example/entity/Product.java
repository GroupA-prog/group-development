package jp.co.example.entity;

import jp.co.example.util.ParamUtil;

/**
 * productsテーブルのEntity
 */
public class Product {
    private Integer productId;
    private String productName;
    private Integer price;

    public Product() {

    }

    public Product(Integer productId, String productName, Integer price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [product_id=" + productId + ", product_name=" + productName + ", price=" + price + "]";
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    // 全フィールドが未入力かの判断
    public boolean isEmptyCondition() {
        return productId == null && ParamUtil.isNullOrEmpty(productName) && price == null;
    }
}
