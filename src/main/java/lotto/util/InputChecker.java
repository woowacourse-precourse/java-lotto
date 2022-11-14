package lotto.util;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;

public class InputChecker {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static final Integer LIMITED_LENGTH = 6;
    public final static int UNIT = 1000;

    public static final String ERROR = "[ERROR] ";
    private static final String IS_NOT_RECEIVE_CHARACTER = "문자열은 입력할 수 없습니다.";

    private static final String IS_OVER_LIMITED_LENGTH = "로또 번호는 " + LIMITED_LENGTH + " 개만 입력할 수 있습니다.";
    private static final String IS_NOT_RANGE_NUMBER = "로또 번호는 " + START_NUMBER + " ~ " + END_NUMBER + "만 입력할 수 있습니다.";
    private static final String IS_NOT_VALID_PRICE = "로또는 " + UNIT + " 단위로 구매할 수 있습니다.";
    private static final String IS_SELECTED_NUMBER = "이전에 선택한 번호는 보너스 번호가 될 수 없습니다.";
    private static final String REGEX = "[0-9]+";

    private InputChecker() {
    }


    public static Integer checkPrice(String input) {
        isNumber(input);
        Integer price = Integer.parseInt(input);
        if (isNotDivide(price)) {
            throw new IllegalArgumentException(IS_NOT_VALID_PRICE);
        }
        return price;
    }

    public static List<Integer> checkPrizeLottoInput(String input) {
        List<Integer> lotto = Arrays.stream(input.split(","))
                .filter(InputChecker::isNumber)
                .map(Integer::parseInt)
                .filter(InputChecker::isCollectedRange)
                .sorted()
                .collect(toList());
        return checkLottoNumbers(lotto);
    }

    public static List<Integer> checkLottoNumbers(List<Integer> numbers) {
        List<Integer> lotto = numbers.stream()
                .filter(InputChecker::isCollectedRange)
                .sorted()
                .distinct()
                .collect(toList());
        checkNumbersLengthIsLimited(lotto);
        return lotto;
    }

    public static Integer checkBonusNumber(String input, List<Integer> numbers) {
        isNumber(input);
        isCollectedRange(Integer.parseInt(input));
        isNotSelected(Integer.parseInt(input), numbers);
        return Integer.parseInt(input);
    }

    private static void isNotSelected(Integer number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(ERROR + IS_SELECTED_NUMBER);
        }
    }

    static void checkNumbersLengthIsLimited(List<Integer> numbers) {
        if (numbers.size() == LIMITED_LENGTH) {
            return;
        }
        throw new IllegalArgumentException(ERROR + IS_OVER_LIMITED_LENGTH);
    }

    static boolean isCollectedRange(Integer number) {
        if (START_NUMBER <= number && number <= END_NUMBER) {
            return true;
        }
        throw new IllegalArgumentException(ERROR + IS_NOT_RANGE_NUMBER);
    }

    static boolean isNumber(String number) {
        if (number.matches(REGEX)) {
            return true;
        }
        throw new IllegalArgumentException(ERROR + IS_NOT_RECEIVE_CHARACTER);
    }

    static boolean isNotDivide(Integer number) {
        return (number % UNIT) != 0;
    }
}
