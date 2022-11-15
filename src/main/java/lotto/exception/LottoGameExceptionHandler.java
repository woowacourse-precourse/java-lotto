package lotto.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGameExceptionHandler {

    public static void handleAmountNotThousandsException(int amount) {
        final int LOTTO_PRICE = 1000;
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] Input value is not in 1000 units.");
        }
    }

    public static void handleNumberOutOfRangeException(int number) {
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException("[ERROR] The number is out of range.");
        }
    }

    public static void handleNotSixNumbersException(List<Integer> numbers) {
        final int NUMBER_OF_NUMBERS = 6;
        if (numbers.size() != NUMBER_OF_NUMBERS) {
            throw new IllegalArgumentException("[ERROR] The numbers are not 6.");
        }
    }

    public static void handleDuplicatedNumbersException(List<Integer> numbers) {
        Set<Integer> checkDuplicate = new HashSet<>();

        for (int number : numbers) {
            if (!checkDuplicate.add(number)) {
                throw new IllegalArgumentException("[ERROR] Duplicate number exists.");
            }
        }
    }

    public static void handleNotAscendingOrderException(List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) > numbers.get(i)) {
                throw new IllegalArgumentException("[ERROR] Lotto numbers are not sorted.");
            }
        }
    }

    public static void handleLottoAndWinningException(List<Integer> numbers) {
        numbers.forEach(LottoGameExceptionHandler::handleNumberOutOfRangeException);

        handleNotSixNumbersException(numbers);
        handleDuplicatedNumbersException(numbers);
    }

    public static void handleLottoException(List<Integer> numbers) {
        handleLottoAndWinningException(numbers);

        handleNotAscendingOrderException(numbers);
    }
}
