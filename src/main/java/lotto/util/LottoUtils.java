package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.view.ExceptionMessage;

public class LottoUtils {

    final static int START_NUMBER = 1;
    final static int END_NUMBER = 45;
    final static int NUMBER_COUNT = 6;
    final static String SEPARATOR = ",";

    public static List<Integer> pickUniqueNumbersInRange() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_COUNT);
        return numbers;
    }

    public static List<Integer> parsingNumberBySeparator(String input) {
        try {
            List<Integer> numbers = Stream.of(input.split(SEPARATOR))
                    .map(s -> Integer.parseInt(s))
                    .sorted()
                    .collect(Collectors.toList());
            return numbers;
        } catch (IllegalArgumentException e) {
            ExceptionMessage.inputNumberError();
            throw e;
        }
    }

    public static void checkNumberInRange(int number) {
        if (number < START_NUMBER || number > END_NUMBER) {
            ExceptionMessage.numberRangeError();
            throw new IllegalArgumentException();
        }
    }

    public static int inputToNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            return number;
        } catch (IllegalArgumentException e) {
            ExceptionMessage.inputNumberError();
            throw e;
        }
    }
}
