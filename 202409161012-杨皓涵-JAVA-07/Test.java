import java.io.*;
import java.rmi.ServerError;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        //创建用于存放文件中读取的整数的集合
        ArrayList<Integer> list = new ArrayList<>();
        double sum = 0;

        //1.读取文件: 在当前目录下，从一个文本文件中读取内容。
        //假设文件名为data.txt，其中每一行包含一个整数。
        //使用try-with-resources语句

        try (FileInputStream fis = new FileInputStream("data.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis))) {
            boolean isEmpty = true;
            String line;
            while ((line = br.readLine()) != null) {
                isEmpty = false; //只要有一行被读取到则文件不为空
                //将读取到的字符串转换为整型封装类并传入集合
                try{list.add(Integer.parseInt(line));}
                //若字符串无法转换为整型，则捕获异常并输出警告信息
                catch(NumberFormatException e){
                    System.err.println("错误的数据类型：" + line);
                }

            }

            if (isEmpty) {
                throw new EmptyFileException("文件为空");// 抛出异常并警告文件为空
            }

            // 将集合中的每个整数相加得到总和
            for (int num : list) {
                sum += num;
            }
            // 将总和除以整数个数即集合的长度得到平均数
            double avg = sum / list.size();
            System.out.println("data.txt文件中共有" + list.size() + "个整数，" +
                    "其平均数为" + avg);

        } catch (FileNotFoundException e) { // 未找到文件
            System.err.println("错误：" + e.getMessage());
        } catch (EmptyFileException e) { // 文件为空
            System.err.println("错误：" + e.getMessage());
        } catch (IOException e) { // IO异常
            System.err.println("发生IO异常：" + e.getMessage());
        } finally {
            System.out.println("读取的文件资源已被成功关闭..."); // 确保文件资源被成功关闭
        }

    }
}

class EmptyFileException extends RuntimeException {
    public EmptyFileException(String message) {
        super(message);
    }
}


