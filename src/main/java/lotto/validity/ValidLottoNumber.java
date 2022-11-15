package lotto.validity;

import lotto.constants.Constants;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidLottoNumber {
    public static final String ErrorMessage_NumberRange = "[ERROR] 로또 번호는 1~45 사이의 숫자만 입력해 주세요.";
    public static final String ErrorMessage_NumberSize = "[ERROR] 로또 번호의 개수는 6개만 입력해 주세요.";
    public static final String ErrorMessage_NumberOverlap = "[ERROR] 중복된 번호가 포함되어 있습니다.";
    public static final String ErrorMessage_BonusOverlap = "[ERROR] 보너스 번호가 당첨 번호에 포함되어 있습니다.";

    public static void validRange(int number) {
        if (outRange(number)) {
            throw new IllegalArgumentException(ErrorMessage_NumberRange);
        }
    }

    private static boolean outRange(int number) {
        return (number < Constants.MIN) || (number > Constants.MAX);
    }

    public static void validNumbers(List<Integer> numbers) {
        overSize(numbers);
        overlapNumbers(numbers);
    }

    public static void validBonus(List<Integer> numbers, int number) {
        overlapBonus(numbers, number);
    }

    private static void overSize(List<Integer> numbers) {
        if (numbers.size() != Constants.MAX_COUNT) {
            throw new IllegalArgumentException(ErrorMessage_NumberSize);
        }
    }

    private static void overlapNumbers(List<Integer> numbers) {
        Set<Integer> removeOverlapNumbers = new HashSet<>(numbers);
        if (removeOverlapNumbers.size() != Constants.MAX_COUNT) {
            throw new IllegalArgumentException(ErrorMessage_NumberOverlap);
        }
    }

    private static void overlapBonus(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage_BonusOverlap);
        }
    }
}
