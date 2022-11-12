package lotto.util;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.Constants.*;

public class Validator {
    private final static String ERROR_TITLE = "[ERROR] ";
    private final static String NON_NUMERIC = "숫자 이외의 값이 입력되었습니다. 문자나 띄어쓰기 등이 들어갔는지 확인해주세요.";
    private final static String NOT_IN_THOUSANDS = "금액은 천 원 단위로만 입력할 수 있습니다.";
    private final static String NOT_SIX_NUMBERS = "로또 번호의 개수가 6개가 아닙니다.";
    private final static String DUPLICATE_NUMBERS = "겹치는 로또 번호가 존재합니다.";
    private final static String OUT_OF_RANGE = "로또 번호는 1부터 45 사이의 숫자들로 이루어져야 합니다.";
    private final static String NO_COMMAS_FOUND = "당첨 번호는 쉼표(,)를 기준으로 구분됩니다.";
    private final static String ONLY_NUMBER_REGEX = "^\\d+$";
    private final static String IN_THOUSANDS = "000";

    public static void checkIfNumeric(String input) {
        boolean isNumber = input.matches(ONLY_NUMBER_REGEX);
        if (!isNumber) {
            throw new IllegalArgumentException(ERROR_TITLE + NON_NUMERIC);
        }
    }

    public static void checkIfInThousands(String input) {
        String lastThreeDigits = input.substring(input.length() - 3);
        if (!lastThreeDigits.equals(IN_THOUSANDS)) {
            throw new IllegalArgumentException(ERROR_TITLE + NOT_IN_THOUSANDS);
        }
    }

    public static void checkSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_TITLE + NOT_SIX_NUMBERS);
        }
    }

    public static void checkUniqueness(List<Integer> numbers) {
        List<Integer> numbersToBeValidated = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        if (numbersToBeValidated.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_TITLE + DUPLICATE_NUMBERS);
        }
    }

    public static void checkRange(Integer number) {
        if (number < START_NUMBER_INCLUSIVE || number > END_NUMBER_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_TITLE + OUT_OF_RANGE);
        }
    }

    public static void checkFormat(String[] numbers) {
        if (numbers.length != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_TITLE + NO_COMMAS_FOUND);
        }
    }

    public static void checkIfWinningNumbersContainBonusNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_TITLE + DUPLICATE_NUMBERS);
        }
    }
}
