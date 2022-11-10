package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class StringToInteger {

    public static List<Integer> convert(List<String> numbers) {
        List<Integer> result = new ArrayList<>();

        for (String number : numbers) {
            result.add(Integer.parseInt(number));
        }
        return result;
    }
}
