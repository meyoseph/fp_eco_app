package util;

import beans.Product;
import beans.Shop;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class FunctionUtil {
    public static Function<Shop, List<String>> getALLProductName = shop -> shop.getProducts().stream()
            .map(product -> product.getProductName()).collect(Collectors.toList());

    public static BiFunction<Shop,String, List<Product>> getProductListByTag = (shop,tag) -> shop.getProducts().stream()
            .filter(product -> product.getTag().equals(tag)).collect(Collectors.toList());

    //public static BiFunction<List<Product>,String, List<Product>> getDiscountsGroupedByAssociatedDiscount =>
}
