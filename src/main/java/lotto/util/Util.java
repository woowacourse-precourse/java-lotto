package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static List<Integer> stringToIntegerList(String numbers) {
        List<Integer> result = new ArrayList<>();
        for (String number : numbers.split(",")) {
            result.add(Integer.valueOf(number));
        }
        return result;
    }

}
