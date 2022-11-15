package lotto.Utils;

import java.util.*;
import java.util.stream.Collectors;

public class CommonUtil {
    public static int stringToNumber(String input) {
        int number = 0;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            Error.generate(Message.AMOUNT);
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
            Error.generate(Message.AMOUNT);
        }
        return result;
    }

    private static void checkDuplicated(List<Integer> numbers) {
        HashSet<Integer> duplicatesExcluded = new HashSet<>(numbers);
        if (duplicatesExcluded.size() != 6) {
            Error.generate(Message.DUPLICATED);
        }
    }
    private static void checkRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                Error.generate(Message.DUPLICATED);
            }
        }
    }
    public static void validateLotto(List<Integer> numbers) {
        checkDuplicated(numbers);
        checkRange(numbers);
    }
}
