import beans.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class TestFactory {


    static public Shop createShop(String name, List<Product> products){
        Shop shop = new Shop();
        shop.setName(name);
        shop.setProducts(products);

        return shop;
    }


    static public Staff createStaff(String firstName, String lastName, Shop shop){
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);

        Staff staff = new Staff();
        staff.setShop(shop);

        person.setRoles(Stream.concat(person.getRoles().stream(), new ArrayList<Role>(List.of(staff)).stream()).collect(Collectors.toList()));

        return staff;
    }

    static public Customer createCustomer(String firstName, String lastName, String email){
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);

        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setOrders(new ArrayList<>());

        person.setRoles(Stream.concat(person.getRoles().stream(), new ArrayList<Role>(List.of(customer)).stream()).collect(Collectors.toList()));

        return customer;
    }

    static public Customer createCustomer(String firstName, String lastName, String email, List<Order> orders){
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);

        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setOrders(orders);

        person.setRoles(Stream.concat(person.getRoles().stream(), new ArrayList<Role>(List.of(customer)).stream()).collect(Collectors.toList()));

        return customer;
    }

    static public Customer assignCustomer(Customer customer, String email){
        customer.setEmail(email);
        return customer;
    }


    static public Customer assignCustomer(Customer customer, List<Order> orders){
        customer.setOrders(Stream.concat(customer.getOrders().stream(), orders.stream()).collect(Collectors.toList()));
        return customer;
    }

    static public Limit createLimit(String type, int value){
        Limit limit = new Limit();
        limit.setType(type);
        limit.setValue(value);
        return limit;
    }

    static public Tag createLimit(String name){
        Tag tag = new Tag();
        tag.setName(name);
        return tag;
    }

    static public Product createProduct(String productName, String productType, String productDesc, List<Discount> discounts, Tag tag, List<Limit> limits){
        Product product = new Product();
        product.setProductName(productName);
        product.setProductType(productType);
        product.setProductDescription(productDesc);

        product.setDiscounts(discounts);
        product.setTag(tag);
        product.setLimits(limits);

        return product;
    }

    static public Order createOrder(LocalDateTime date, List<Product> products, Payment payment){
        Order order = new Order();
        order.setDateTime(date);
        order.setPayment(payment);

        return order;
    }

}
