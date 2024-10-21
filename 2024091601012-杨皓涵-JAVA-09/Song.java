import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song implements Serializable {
    private String title;
    private String artist;
    private String genre;
    private int year;
    private int timesPlayed;
    //	利用注解或者自己创建构造器和get方法

    @Override
    public int hashCode() {
        return Objects.hashCode(getGenre());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        if (!Objects.equals(genre, song.genre)) return false;
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
//        Stream<Song> song = Songs.getSongs().stream();
//        //List<Song> song_ = song.filter(song1 -> song1.genre.equals("Rock")).toList();
//        List<Song> song_ = song.distinct().toList();
//        song_.forEach(song1 -> System.out.println(song1.genre));

        // 串行化输出
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("Songs.dat"));
        oos.writeObject(Songs.getSongs());
        System.out.println("串行化输出成功~");

        // 反串行化读取
//        ObjectInputStream ois = new ObjectInputStream(
//                                    new FileInputStream("Songs.dat"));
//        List<Song> song_ = (List<Song>)ois.readObject();
//        song_.forEach(System.out::println);

        //
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("Songs.txt"));) {
            Songs.getSongs().forEach(song -> {
                try {
                    bw.write(song.getTitle() +
                            "  ---  " + song.getArtist());
                    bw.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            bw.close();
        }

        BufferedReader br = new BufferedReader(
                new FileReader("Songs.txt"));
        String line;
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();


    }
}

class Songs implements Serializable {
    public static List<Song> getSongs() {
        return List.of(
                new Song("$10", "Hitchhiker", "Electronic", 2016, 183),
                new Song("Havana", "Camila Cabello", "R&B", 2017, 324),
                new Song("Cassidy", "Grateful Dead", "Rock", 1972, 123),
                new Song("50 ways", "Paul Simon", "Soft Rock", 1975, 199),
                new Song("Hurt", "Nine Inch Nails", "Industrial Rock", 1995, 257),
                new Song("Silence", "Delerium", "Electronic", 1999, 134),
                new Song("Hurt", "Johnny Cash", "Soft Rock", 2002, 392),
                new Song("Watercolour", "Pendulum", "Electronic", 2010, 155),
                new Song("The Outsider", "A Perfect Circle", "Alternative Rock", 2004, 312),
                new Song("With a Little Help from My Friends", "The Beatles", "Rock", 1967, 168),
                new Song("Come Together", "The Beatles", "Blues rock", 1968, 173),
                new Song("Come Together", "Ike & Tina Turner", "Rock", 1970, 165),
                new Song("With a Little Help from My Friends", "Joe Cocker", "Rock", 1968, 46),
                new Song("Immigrant Song", "Karen O", "Industrial Rock", 2011, 12),
                new Song("Breathe", "The Prodigy", "Electronic", 1996, 337),
                new Song("What's Going On", "Gaye", "R&B", 1971, 420),
                new Song("Hallucinate", "Dua Lipa", "Pop", 2020, 75),
                new Song("Walk Me Home", "P!nk", "Pop", 2019, 459),
                new Song("I am not a woman, I'm a god", "Halsey", "Alternative Rock", 2021, 384),
                new Song("Pasos de cero", "Pablo Alborán", "Latin", 2014, 117),
                new Song("Smooth", "Santana", "Latin", 1999, 244),
                new Song("Immigrant song", "Led Zeppelin", "Rock", 1970, 484));
    }
}
