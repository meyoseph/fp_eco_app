package util;

import beans.*;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class FunctionUtil {
    public static Function<Shop, List<String>> getALLProductName = shop -> shop.getProducts().stream()
            .map(product -> product.getProductName()).collect(Collectors.toList());

    public static BiFunction<Shop,String, List<Product>> getProductListByTag = (shop,tag) -> shop.getProducts().stream()
            .filter(product -> product.getTag().getName().equals(tag)).collect(Collectors.toList());

    public static Function<List<Product>, List<Map.Entry>> getALlProductsGroupedByTag = products -> products.stream()
            .collect(Collectors.groupingBy(product -> product.getTag())).entrySet().stream().collect(Collectors.toList());

    public static Predicate<Product> isLimitPresent = product -> product.getLimits().size() > 0;
}
