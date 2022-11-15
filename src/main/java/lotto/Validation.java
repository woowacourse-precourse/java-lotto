package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Validation {
    public static void checkPurchaseInput(String str) {
        checkNumberFormat(str);
        checkValidPurchaseCost(str);
    }
    public static void checkWinningNumberInput(String numbers) {
        List<String> winningNumbers = new ArrayList<>(List.of(numbers.split(",")));

        checkValidLength(winningNumbers);
        checkDuplicatedNumber(winningNumbers);

        for (String winningNumber : winningNumbers) {
            checkNumberFormat(winningNumber);
            checkValidNumberRange(winningNumber);
        }
    }

    public static void checkBonusNumberInput(String str) {
        checkNumberFormat(str);
        checkValidNumberRange(str);
    }

    public static void checkLottoNumbers(List<Integer> numbers) {
        List<String> lottoNumbers = changeToStrList(numbers);

        checkValidLength(lottoNumbers);
        checkDuplicatedNumber(lottoNumbers);

        for (String lottoNumber : lottoNumbers) {
            checkValidNumberRange(lottoNumber);
        }
    }

    private static void checkNumberFormat(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!isNumber(str.charAt(i))) {
                throw new IllegalArgumentException(ErrorType.INVALID_FORMAT.getErrorMsg());
            }
        }
    }

    private static boolean isNumber(char c) {
        return '0' <= c && c <= '9';
    }

    private static void checkValidPurchaseCost(String str) {
        int cost = Integer.parseInt(str);
        if ((cost % Lotto.LOTTO_PRICE) != 0) {
            throw new IllegalArgumentException(ErrorType.INVALID_PURCHASE_COST.getErrorMsg());
        }
    }

    private static void checkValidLength(List<String> str) {
        if (str.size() != Lotto.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorType.INVALID_LENGTH.getErrorMsg());
        }
    }

    private static void checkDuplicatedNumber(List<String> numbers) {
        Set<String> storedNumbers = new HashSet<>();

        for (String winningNumber : numbers) {
            if (storedNumbers.contains(winningNumber)) {
                throw new IllegalArgumentException(ErrorType.DUPLICATED_NUMBER.getErrorMsg());
            }
            storedNumbers.add(winningNumber);
        }
    }

    private static void checkValidNumberRange(String str) {
        int number = Integer.parseInt(str);

        if (!isValidRange(number)) {
            throw new IllegalArgumentException(ErrorType.INVALID_RANGE.getErrorMsg());
        }
    }

    private static List<String> changeToStrList(List<Integer> numbers) {
        return numbers.stream()
                .map(value -> value.toString())
                .collect(Collectors.toList());
    }

    private static boolean isValidRange(int number) {
        return Lotto.MIN_LOTTO_NUMBER <= number && number <= Lotto.MAX_LOTTO_NUMBER;
    }
}