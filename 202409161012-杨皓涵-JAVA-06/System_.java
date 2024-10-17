import Customer.Customer;
import Menu.Order;

import java.util.List;
import java.util.Scanner;

public class System_ {
        //请补全处理订单的函数

        //声明静态变量OrderId储存订单编号，初始值为1
        private static int OrderId = 1;

        Scanner myScanner = new Scanner(java.lang.System.in);

        public <E extends Customer> void manageOrder(List<Order> dishes, E e) {

            //要求1：一旦订单里有一个菜品的原料不足以烹饪，就输出“取消订单”，
            //否则输出所有菜品的烹饪方法，最后再输出该订单的编号，编号从1开始递增。

                boolean All_Can_Cook = true; // 判断是否可以烹饪，默认为true
                // 遍历Order集合，只要有一个菜品不能烹饪，就返回false
                for (Order order : dishes) {
                        if (!order.check()) {
                                All_Can_Cook = false;
                                break;
                        }
                        continue;
                }

                // 如果所有菜品都可以烹饪，就遍历输出菜品烹饪方法
                // 否则输出警告信息并退出方法
                if (All_Can_Cook) {
                        for (Order order : dishes) {
                                order.cook();

                        }
                        java.lang.System.out.println("订单编号：" + OrderId);// 在循环结束后输出订单编号
                        OrderId++; // 每一个成功订单后编号+1
                        e.ServiceDetails();


                }
                else {
                        java.lang.System.out.println("原材料不足，取消订单\n");
                        return;
                }
        }



}
