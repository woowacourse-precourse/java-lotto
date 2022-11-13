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

    public static List<Integer> joinIntegerList(List<Integer> userNumbers,
        List<Integer> winningNumbers) {
        List<Integer> joinedNumbers = new ArrayList<>();
        joinedNumbers.addAll(userNumbers);
        joinedNumbers.addAll(winningNumbers);
        return joinedNumbers;
    }

}
