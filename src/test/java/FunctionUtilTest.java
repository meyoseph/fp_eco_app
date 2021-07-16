

import beans.Limit;
import beans.Product;
import beans.Shop;
import mock.ShopMock;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import util.FunctionUtil;

import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionUtilTest {

    @Test
    public void itShouldGetAllProductNameFromShop(){
        List<Shop> shops = ShopMock.getListOfShop();
        List<String> expectedResult = shops.get(0).getProducts().stream().map(product -> product.getProductName()).collect(Collectors.toList());
        List<String> actualResult = FunctionUtil.getALLProductName.apply(shops.get(0));
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void itShouldQueryProductsByTagAndReturn(){
        List<Shop> shops = ShopMock.getListOfShop();
        List<Product> expectedResult = shops.get(0).getProducts().stream()
                .filter(product -> product.getTag().getName().equals("shoes")).collect(Collectors.toList());
        List<Product> actualResult = FunctionUtil.getProductListByTag.apply(shops.get(0), "shoes");
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void itShouldReturnLimitIfMinLimitIsPeresent(){
        Product product = new Product();
        Limit limit = new Limit();
        limit.setType("min");
        limit.setValue(2);
        List<Limit> limits = new ArrayList<>();
        limits.add(limit);
        product.setLimits(limits);
        Optional<Limit> expectedOptionalLimit = product.getLimits().stream()
                .filter(l -> l.getType().equals("min"))
                .findAny();
        Optional<Limit> actualOptionalLimit = FunctionUtil.isMinLimitPresent.apply(product);
        assertEquals(expectedOptionalLimit,actualOptionalLimit);
    }

    @Test
    public void itSouldReturnProductsWithMinLimitSet(){
        Product product = new Product();
        Limit limit = new Limit();
        limit.setType("min");
        limit.setValue(2);
        List<Limit> limits = new ArrayList<>();
        limits.add(limit);
        product.setLimits(limits);
        Function<Product, Optional<Limit>> isMinLimitPresent = p -> p.getLimits().stream()
                .filter(l -> l.getType().equals("min"))
                .findAny();
        List<Product> products = new ArrayList<>();
        products.add(product);
        List<Product> expectedProducts = products.stream()
                .filter(pp -> isMinLimitPresent.apply(pp).isPresent())
                .collect(Collectors.toList());
        List<Product> actualResult = FunctionUtil.getALLProductsThatHaveMinLimit.apply(products);
        assertEquals(expectedProducts,actualResult);
    }


}


