package util;

import beans.*;
import util.custom.function.QuadFunction;
import util.custom.function.TriFunction;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Double.valueOf;

public abstract class FunctionUtil2 {

    public static Function<List<Person>, List<Customer>> fromPersonsToCustomers = people ->
            people.stream()
                    .flatMap(person -> person.getRoles().stream())
                    .filter(role -> role instanceof Customer)
                    .map(role -> (Customer) role)
                    .collect(Collectors.toList());

    public static Function<List<Person>, List<Staff>> fromPersonsToStaff = people ->
            people.stream()
                    .flatMap(person -> person.getRoles().stream())
                    .filter(role -> role instanceof Staff)
                    .map(role -> (Staff) role)
                    .collect(Collectors.toList());

    //Returns how much discount was made on a specific product!
    public static final Function<Payment, Optional<Double>> discountsMade = (payment) ->
            payment.getProducts().stream()
                    .flatMap(product -> product.getDiscounts().stream())
                    .map(discount -> discount.getDiscountPercent())
                    .reduce((aDouble, aDouble2) -> aDouble+aDouble2);

    //Returns how much a customer payed overall on a given year while still receiving more than K discount on a specific year!
    public static final TriFunction<Customer, Long, Double, Optional<Double>> topPayingCustomersWithMoreThanKDiscounts = (customer, year, amount) ->
            Optional.ofNullable(customer.getOrders().stream()
                    .filter(order -> order.getDateTime().getYear() == year)
                    .filter(order -> discountsMade.apply(order.getPayment()).isPresent())
                    .filter(order -> discountsMade.apply(order.getPayment()).get() >= amount)
                    .map(order -> order.getPayment().getSubTotal())
                    .reduce((aDouble, aDouble2) -> aDouble + aDouble2)).orElse(null);

    //K List Of customers Who payed more than all while still receiving more than K discount  on a specific year!
    public static final QuadFunction<List<Person>, Long, Double, Long, List<String>> topKPayingCustomersOnKDiscounts = (people, year, amount, k) ->
            fromPersonsToCustomers.apply(people).stream()
                    .filter(o -> topPayingCustomersWithMoreThanKDiscounts.apply(o, year, amount).isPresent() )
                    .sorted((o1, o2) -> (int) (topPayingCustomersWithMoreThanKDiscounts.apply(o2, year, amount).get() - topPayingCustomersWithMoreThanKDiscounts.apply(o1, year, amount).get() ))
                    .map(customer -> customer.getPerson().getFirstName() + " " + customer.getPerson().getLastName())
                    .limit(k)
                    .collect(Collectors.toList());


    //Get product name of products under most taxed K Orders on a specific year!
    public static final TriFunction<Shop, Long, Long, List<String>> topKMostTaxedProductOnKYear = (shop, year, k) ->
            shop.getStaffs().stream()
                    .filter(staff -> staff.getOrders() != null)
                    .flatMap(staff -> staff.getOrders().stream())
                    .filter(order -> order.getDateTime().getYear() == year)
                    .map(order -> order.getPayment())
                    .sorted((o1, o2) -> (int) (o2.getTax() - o1.getTax()))
                    .flatMap(payment -> payment.getProducts().stream())
                    .distinct()
                    .map(product -> product.getProductName())
                    .limit(k)
                    .collect(Collectors.toList());


    //Get Customer who paid the most tax in a specific year!
    public static final TriFunction<Shop, Long, Long, List<String>> topTaxPayingCustomerOnKYear = (shop, year, k) ->
            shop.getStaffs().stream()
                    .filter(staff -> staff.getOrders() != null)
                    .flatMap(staff -> staff.getOrders().stream())
                    .filter(order -> order.getDateTime().getYear() == year)
                    .map(order -> order.getPayment())
                    .sorted((o1, o2) -> (int) (o2.getTax() - o1.getTax()))
                    .limit(k)
                    .flatMap(payment -> payment.getOrders().getCustomers().stream())
                    .distinct()
                    .map(customer -> customer.getPerson().getFirstName() + " " + customer.getPerson().getLastName())
                    .collect(Collectors.toList());





}
