package mock;

import beans.*;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

public class ShopMock {
    public static List<Shop> getListOfShop(){
        List<Shop> shops = new ArrayList<>();
        List<Staff> staffs = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        List<Limit> limits = new ArrayList<>();
        List<Discount> discounts = new ArrayList<>();

        Staff staff1 = new Staff();
        Staff staff2 = new Staff();
        Staff staff3 = new Staff();
        Staff staff5 = new Staff();
        Staff staff6 = new Staff();
        Staff staff7 = new Staff();
        Staff staff8 = new Staff();
        Staff staff9 = new Staff();
        Staff staff10 = new Staff();

        // product limits
        Limit limitMinValueOf2 = new Limit();
        limitMinValueOf2.setValue(2);
        limitMinValueOf2.setType("min");

        Limit limitMaxValueOf12 = new Limit();
        limitMaxValueOf12.setValue(12);
        limitMaxValueOf12.setType("max");
        Limit limitMultipleOf2 = new Limit();
        limitMultipleOf2.setValue(2);
        limitMaxValueOf12.setType("multiple");

        // populate limits list
        limits.add(limitMinValueOf2);
        limits.add(limitMaxValueOf12);
        limits.add(limitMultipleOf2);


        // tags
        Tag tag1 = new Tag();
        tag1.setName("books");
        Tag tag2 = new Tag();
        tag2.setName("shoes");
        Tag tag3 = new Tag();
        tag3.setName("t-shirt");

        // discount
        Discount discount1 = new Discount();
        discount1.setDiscountType("blackfriday");
        discount1.getDiscountPercent(5.0);
        Discount discount2 = new Discount();
        discount2.setDiscountType("cybermonday");
        discount2.getDiscountPercent(2.0);

        // populate discounts
        discounts.add(discount1);
        discounts.add(discount2);

        // Product
        Product product1 = new Product();
        product1.setProductName("All Star");
        product1.setLimits(limits);
        product1.setTag(tag2);
        product1.setDiscounts(discounts);

        Product product2 = new Product();
        product1.setProductName("Aldo");
        product1.setLimits(limits);
        product1.setTag(tag2);
        product1.setDiscounts(discounts);

        Product product3 = new Product();
        product1.setProductName("Adidas outdoor");
        product1.setLimits(limits);
        product1.setTag(tag2);
        product1.setDiscounts(discounts);

        Product product4 = new Product();
        product1.setProductName("Brooks");
        product1.setLimits(limits);
        product1.setTag(tag2);
        product1.setDiscounts(discounts);

        Product product5 = new Product();
        product1.setProductName("Bull");
        product1.setLimits(limits);
        product1.setTag(tag2);
        product1.setDiscounts(discounts);

        Product product6 = new Product();
        product1.setProductName("Bull");
        product1.setLimits(limits);
        product1.setTag(tag2);
        product1.setDiscounts(discounts);

        Product product7 = new Product();
        product1.setProductName("Carters");
        product1.setLimits(limits);
        product1.setTag(tag2);
        product1.setDiscounts(discounts);

        Product product8 = new Product();
        product1.setProductName("Disney shoes");
        product1.setLimits(limits);
        product1.setTag(tag2);
        product1.setDiscounts(discounts);

        Product product9 = new Product();
        product1.setProductName("Dockers");
        product1.setLimits(limits);
        product1.setTag(tag2);
        product1.setDiscounts(discounts);

        Product product10 = new Product();
        product1.setProductName("Dingo");
        product1.setLimits(limits);
        product1.setTag(tag2);
        product1.setDiscounts(discounts);

        //populate shops
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
        products.add(product7);
        products.add(product8);
        products.add(product9);
        products.add(product10);


        //populate staffs
        staffs.add(staff1);

        Shop shop1 = new Shop();
        shop1.setName("jstore");
        shop1.setStaffs(staffs);
        shop1.setProducts(products);

        // populate shops
        shops.add(shop1);

        return shops;
    }
}
