package Menu;

import java.util.Random;

public interface Order {

    default void cook() {

    }

    default boolean check() {
        //法一：
        //return Math.random() < 0.5;

        //法二：
        return new Random().nextBoolean();
    }


}
