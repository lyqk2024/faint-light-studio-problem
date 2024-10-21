import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Limit_ {
    public static void main(String[] args) {
//        List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");
//        Stream<String> stream = strings.stream();
//        ////调用流API的方法，例如我们希望最多有4个元素
//        //Stream<String> limit = stream.limit(4);
//        ////最后我们打印结果
//        //System.out.println("limit = " + limit);
//
//        stream.limit(4).forEach(System.out::println);


        List<Integer> numbers = List.of (1, 2, 3, 4, 5, 6, 7, 8, 9, 10  );
        List<Integer> squaresList = numbers.stream()
                .map(i -> i * i)	//你可能会对这种表达式有兴趣
                .sorted((x, y) -> y - x)//你可能会对这种表达式有兴趣
                .collect(Collectors.toList());
        System.out.println(squaresList);
    }
}
