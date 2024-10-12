package task1;

import java.util.Scanner;

public class for_while {
    public static void main(String[] args) {

        int n;

        for_while For_while = new for_while();
        System.out.println("请输入n的值");
        while(true) {
            Scanner myScanner = new Scanner(System.in);
            n = myScanner.nextInt();
            if (n % 2 == 1 && n > 0) {
                break;
            }
            System.out.println("输入的n值有误，重新输入...");
        }
        For_while.print(n);
    }


    void print(int n){

        //这个函数打印一个高度为n的空心菱形，保证n为奇数
        //如n=5,则打印如下图形：
        //  *
        // * *
        //*   *
        // * *
        //  *

        //打印空心菱形的上半部分
        for (int i = 0; i <= (n-1)/2; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == (n+1)/2 - i|| j == (n+1)/2 + i) {
                    System.out.print("*");
                    continue;
                }
                System.out.print(" ");
            }
            System.out.println();
        }

        //打印空心菱形的下半部分
        for (int i = (n-1)/2 - 1; i >= 0; i--) {
            for (int j = 1; j <= n; j++) {
                if (j == (n+1)/2 - i|| j == (n+1)/2 + i) {
                    System.out.print("*");
                    continue;
                }
                System.out.print(" ");
            }
            System.out.println();
        }

    }

}

