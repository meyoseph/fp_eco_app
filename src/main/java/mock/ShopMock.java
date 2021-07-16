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
        Limit limitMinValueOf2 = new Limit("min", 2);
        Limit limitMaxValueOf12 = new Limit("max", 12);
        Limit limitMultipleOf2 = new Limit("multiple", 2);

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
        Discount discount2 = new Discount();
        discount2.setDiscountType("cybermonday");

        // Product
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();
        Product product5 = new Product();
        Product product6 = new Product();
        Product product7 = new Product();
        Product product8 = new Product();
        Product product9 = new Product();
        Product product10 = new Product();

        return null;
    }
}
