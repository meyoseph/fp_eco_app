package beans;

import java.util.List;

public class Product {
    private String productName;
    private String productType;
    private String productDescription;
    private List<Limit> lists;
    private Tag tag;
    private List<Discount> discount;

    public Product() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public List<Limit> getLists() {
        return lists;
    }

    public void setLists(List<Limit> lists) {
        this.lists = lists;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public List<Discount> getDiscount() {
        return discount;
    }

    public void setDiscount(List<Discount> discount) {
        this.discount = discount;
    }
}
