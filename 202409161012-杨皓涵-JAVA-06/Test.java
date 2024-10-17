import Customer.*;
import Menu.*;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Order> dishes = new ArrayList<>();
        dishes.add(new Dish_1());
        dishes.add(new Dish_2());

        TableCustomer tableCustomer = new TableCustomer(5);
        WechatCustomer wechatCustomer = new WechatCustomer("123 Street", true);

        System_ system = new System_();

        // 测试堂食顾客
        system.manageOrder(dishes, tableCustomer);
        system.manageOrder(dishes, tableCustomer);
        system.manageOrder(dishes, tableCustomer);
        system.manageOrder(dishes, tableCustomer);

        // 测试外卖顾客
        system.manageOrder(dishes, wechatCustomer);
    }

}


