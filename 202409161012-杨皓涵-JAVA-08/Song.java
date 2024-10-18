import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
@AllArgsConstructor
// 这里的注解代表类的构造器（全参）以及所有数据的get和
// set函数,建议自己写代码实现构造器和get
@NoArgsConstructor
// 略略略，手写是不可能滴
public class Song{
    private String title;
    private String artist;
    private int bpm;

    public static void main (String[] args){

        List<Song> songs = MockMusics.getSongObjects();

        // 以歌曲名字的字母顺序排序
        //BubbleSort(songs); // 仍然可以使用冒泡排序
        songs.sort(Comparator.comparing(Song::getTitle));

        //System.out.println(songs); // toString方法
        //songs.forEach(song -> System.out.print(song));// lambda表达式
        songs.forEach(System.out::println); //
    }

    public static void BubbleSort(List<Song> songs) {
        // 冒泡算法中的变量，用于判断是否排序完成
        boolean swapped = false;

        // 最多冒泡n-1次
        for (int i = 0; i < songs.size() - 1; i++) {
            swapped = false;
            //每次排序参与的元素依次减少一
            for (int j = 0; j < songs.size() - i - 1; j++) {
                //判断j与j+1号歌曲名字的字母顺序
                if (songs.get(j).getTitle().compareTo(songs.get(j+1).getTitle()) > 0) {
                    // 将j与j+1的元素互换
                    Song temp = songs.get(j);
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

class MockMusics {
    public static List<Song> getSongObjects() {
        List<Song> songs = new ArrayList<>();
        // 模拟将要处理的列表
        songs.add(new Song("sunrise", "Artist A", 120));
        songs.add(new Song("noprice", "Artist B", 130));
        songs.add(new Song("thanks", "Artist C", 110));
        songs.add(new Song("havana", "Artist D", 140));
        songs.add(new Song("114514", "Artist E", 100));
        return songs;
    }
}

