package lotto.model;

import static lotto.engine.NextstepNumberGenerator.COUNT;
import static lotto.engine.NextstepNumberGenerator.END_RANGE_NUMBER;
import static lotto.engine.NextstepNumberGenerator.START_RANGE_NUMBER;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lotto.error.Error;

public class WinningNumber {
    private static final String NUMBER_INPUT_REGEX = "^(\\d{1,2},){5}(\\d{1,2}$)";
    private static final String BONUS_INPUT_REGEX = "^(\\d{1,2})$";

    private final List<Integer> numbers;
    private final int bonusNumber;

    private WinningNumber(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public Optional<Winning> compareToWinningNumber(Lotto lotto) {
        if (lotto == null) {
            throw new IllegalArgumentException();
        }

        int correctNumber = (int) lotto.getNumbers().stream()
                .filter(numbers::contains)
                .count();

        boolean bonus = lotto.getNumbers().stream()
                .anyMatch(n -> n == bonusNumber);

        return Winning.findByCountAndBonus(correctNumber, bonus);
    }

    public static WinningNumber of(String userInputNumber, String userInputBonusNumber) {
        if (userInputNumber == null
                || userInputBonusNumber == null
                || userInputBonusNumber.isEmpty()
                || userInputNumber.isEmpty()
        ) {
            throw new IllegalArgumentException(Error.WINNING_EMPTY_INPUT_ERROR.getMessage());
        }

        List<Integer> numbers = parseToNumbers(userInputNumber);
        int bonusNumber = parseToBonusNumber(userInputBonusNumber, numbers);

        return new WinningNumber(numbers, bonusNumber);
    }

    private static List<Integer> parseToNumbers(String userInputNumber) {
        if (!userInputNumber.matches(NUMBER_INPUT_REGEX)) {
            throw new IllegalArgumentException(Error.INPUT_FORMAT_ERROR.getMessage());
        }

        List<Integer> numbers = Arrays.stream(userInputNumber.split(","))
                .map(Integer::parseInt)
                .filter(n -> n >= START_RANGE_NUMBER && n <= END_RANGE_NUMBER)
                .collect(Collectors.toList());

        if (numbers.size() < COUNT) {
            throw new IllegalArgumentException(Error.INPUT_FORMAT_ERROR.getMessage());
        }

        return numbers;
    }

    private static int parseToBonusNumber(String userInputBonusNumber, List<Integer> numbers) {
        if (!userInputBonusNumber.matches(BONUS_INPUT_REGEX)) {
            throw new IllegalArgumentException(Error.BONUS_FORMAT_ERROR.getMessage());
        }

        int bonusNumber = Integer.parseInt(userInputBonusNumber);

        if (bonusNumber > END_RANGE_NUMBER || bonusNumber < START_RANGE_NUMBER || numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Error.BONUS_FORMAT_ERROR.getMessage());
        }

        return bonusNumber;
    }
}
