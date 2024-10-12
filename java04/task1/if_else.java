package task1;

import java.util.Scanner;

public class if_else {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        //接收用户传入的年份
        System.out.println("输入要判断的年份: ");
        int year = myScanner.nextInt();
        A a = new A();

        //使用三元运算符打印结果
        System.out.println(a.isLeapYear(year)? year + "年是闰年":
                year + "年不是闰年");

    }
}


class A {
    //这个函数用于判断传入的年份是否为闰年
    //是闰年返回1，不是闰年返回2
    public boolean isLeapYear(int year){
        // 简便方式
        // return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }

}