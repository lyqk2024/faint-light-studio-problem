import java.util.*;

public class MockSongs {
    public static List<String> getSongStrings(){
        List<String> songs = new ArrayList<>();
        //模拟将要处理的列表
        songs.add("sunrise");
        songs.add("noprice");
        songs.add("thanks");
        songs.add("$100");
        songs.add("havana");
        songs.add("114514");
        return songs;

    }

    public static void main (String[] args) {

        List<String> songs = getSongStrings();

//        //按字母顺序对songs重排
//        Collections.sort(songs);

        //冒泡排序
        BubbleSort(songs);

        //遍历输出
        for (String song : songs) {
            System.out.println(song);
        }
    }

    public static void BubbleSort(List<String> songs) {
        // 冒泡算法中的变量，用于判断是否排序完成
        boolean swapped = false;

        // 最多冒泡n-1次
        for (int i = 0; i < songs.size() - 1; i++) {
            swapped = false;
            //每次排序参与的元素依次减少一
            for (int j = 0; j < songs.size() - i - 1; j++) {
                //判断j与j+1号元素的字母顺序
                if (songs.get(j).compareTo(songs.get(j+1)) > 0) {
                    // 将j与j+1的元素互换
                    String temp = songs.get(j);
                    songs.set(j, songs.get(j + 1));
                    songs.set(j + 1, temp);
                    swapped = true; // 说明排序没有结束，防止退出循环
                }
            }

            //此时集合排序已经完成，退出循环
            if (!swapped) {break;}
        }
    }
}