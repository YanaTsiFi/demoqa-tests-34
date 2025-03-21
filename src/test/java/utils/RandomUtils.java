package utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static String getRandomItemFromArray(String[] array) {
        int index = ThreadLocalRandom.current().nextInt(0, array.length);
        return array[index];
    }
}