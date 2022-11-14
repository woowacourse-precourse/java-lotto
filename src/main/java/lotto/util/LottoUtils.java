package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력되었습니다.");
        }
    }

    public static void checkUniqueNumbers(List<Integer> numbers) {
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 당첨될 수 없습니다.");
        }
    }

    public static void checkNumberInRange(int number) {
        if (number < START_NUMBER || number > END_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static int inputToNumber(String input) {
        int number;

        try {
            number = Integer.parseInt(input);
            return number;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력되었습니다.");
        }
    }
}
