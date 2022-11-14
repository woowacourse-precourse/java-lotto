package lotto.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberException {

    private static final char SEPARATOR = ',';
    private static final int VALID_REMAIN = 0;

    public static void checkUserInputMoney(String userInput) {
        isNumber(userInput);
        isMultipleOfThousand(userInput);
    }

    public static void checkUserInputNumber(String userInput) {
        isNumberInLotto(userInput);
        isValidSeparator(userInput);
        isNotDuplicate(userInput);
        isValidSize(userInput);
        isValidRange(userInput);
    }

    public static void isMultipleOfThousand(String userInput) {
        int userInputMoney = Integer.parseInt(userInput);
        if (userInputMoney % Money.MONEY_UNIT.getMoneyAsInteger() != VALID_REMAIN) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000으로 나누어 떨어져야 합니다.");
        }
    }

    public static void isNumber(String userInput) {
        for (int userInputIndex = 0; userInputIndex < userInput.length(); userInputIndex++) {
            if (!Character.isDigit(userInput.charAt(userInputIndex))) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 숫자로 이루어져야 합니다.");
            }
        }
    }

    public static void isNumberInLotto(String userInput) {
        for (int userInputIndex = 0; userInputIndex < userInput.length(); userInputIndex++) {
            if (userInput.charAt(userInputIndex) == SEPARATOR) {
                continue;
            }
            if (!Character.isDigit(userInput.charAt(userInputIndex))) {
                throw new IllegalArgumentException("[ERROR] 로또번호는 숫자로 이루어져야 합니다.");
            }
        }
    }

    public static void isNotDuplicate(String userInput) {
        List<String> splitUserInput = Arrays.asList(userInput.split(","));
        Set<String> userInputSet = new HashSet<>(splitUserInput);
        if (splitUserInput.size() != userInputSet.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    public static void isValidRange(String userInput) {
        List<String> splitUserInput = Arrays.asList(userInput.split(","));
        List<Integer> userInputNumber = splitUserInput.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int number : userInputNumber) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static void isValidSeparator(String userInput) {
        for (int userInputIndex = 0; userInputIndex < userInput.length(); userInputIndex++) {
            if (Character.isDigit(userInput.charAt(userInputIndex))) {
                continue;
            }
            if (userInput.charAt(userInputIndex) != SEPARATOR) {
                throw new IllegalArgumentException("[ERROR] 로또 번호의 구분자는 쉼표(,)여야 합니다.");
            }
        }
    }

    public static void isValidSize(String userInput) {
        List<String> splitUserInput = Arrays.asList(userInput.split(","));
        if (splitUserInput.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수는 6개여야 합니다.");
        }
    }
}
