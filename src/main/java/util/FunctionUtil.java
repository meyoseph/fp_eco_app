package util;

import beans.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class FunctionUtil {
    public static Function<Shop, List<String>> getALLProductName = shop -> shop.getProducts().stream()
            .map(product -> product.getProductName()).collect(Collectors.toList());

    public static BiFunction<Shop,String, List<Product>> getProductListByTag = (shop,tag) -> shop.getProducts().stream()
            .filter(product -> product.getTag().getName().equals(tag)).collect(Collectors.toList());

    public static Function<Product, Optional<Limit>> isMinLimitPresent = product -> product.getLimits().stream()
            .filter(limit -> limit.getType().equals("min"))
            .findAny();

    public static Function<List<Product>, List<Product>> getALLProductsThatHaveMinLimit = (products) ->
            products.stream()
                    .filter(product -> isMinLimitPresent.apply(product).isPresent())
                    .collect(Collectors.toList());
}
