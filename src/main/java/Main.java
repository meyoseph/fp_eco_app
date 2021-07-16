import beans.Shop;
import mock.ShopMock;
import util.FunctionUtil;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Instructions:");
            System.out.println("-----------------------------");
            System.out.println("Press 1 to get list lof product names");
            System.out.println("Press 0 to exit");
            int input = scanner.nextInt();
            if(input == 1){
                System.out.println("print list of product names");
                List<Shop> shops = ShopMock.getListOfShop();
                List<String> names = FunctionUtil.getALLProductName.apply(shops.get(0));
                names.stream().forEach(System.out::println);
            }
            if(input == 0){
                System.out.println("goodbyeeee......");
                break;
            }
        }
    }
}
