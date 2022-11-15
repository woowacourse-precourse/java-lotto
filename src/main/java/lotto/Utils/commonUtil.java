package lotto.Utils;

import java.util.*;
import java.util.stream.Collectors;
public class commonUtil {
    public static int stringToNumber(String input) {
        int number = 0;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            Error.amountInput();
        }
        return number;
    }

    public static List<Integer> stringToNumbers(String input) {
        List<Integer> result = new ArrayList<>();
        try {
            result = Arrays.stream(input.split(","))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            Error.outOfRange();
        }
        return result;
    }
}
