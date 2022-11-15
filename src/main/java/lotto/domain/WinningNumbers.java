package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<Integer> numbers;
    private final int bonus;

    public WinningNumbers(String numbers, String bonus) {
        this.numbers = validateNumbers(numbers);
        this.bonus = validateBonus(bonus);
    }

    private List<Integer> validateNumbers(String stringNumbers) {
        List<Integer> numbers = validateIsNumber(validateNumbersSize(stringNumbers));

        validateNumbersIsInRange(numbers);

        validateNumbersIsNotDuplicated(numbers);

        return numbers;
    }

    private String[] validateNumbersSize(String stringNumbers) {
        String[] numbers = stringNumbers.split(",");
        if (numbers.length != LottoSettings.LOTTO_SIZE) {
            throw new IllegalArgumentException(String.format(ErrorMessage.WINNING_NUMBERS_SIZE_ERROR_MESSAGE, LottoSettings.LOTTO_SIZE));
        }
        return numbers;
    }

    private List<Integer> validateIsNumber(String[] arrayNumbers) {
        try {
            List<Integer> numbers = new ArrayList<>();
            numbers.addAll(Arrays.stream(arrayNumbers)
                    .map(v -> Integer.parseInt(v))
                    .collect(Collectors.toList()));
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_IS_NOT_INT_ERROR_MESSAGE);
        }
    }

    private void validateNumbersIsInRange(List<Integer> numbers) {
        if (numbers.stream()
                .allMatch(v -> v < LottoSettings.LOTTO_NUMBER_RANGE_START || v > LottoSettings.LOTTO_NUMBER_RANGE_END)) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_IS_NOT_IN_RANGE_ERROR_MESSAGE);
        }
    }

    private void validateNumbersIsNotDuplicated(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .count() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_IS_DUPLICATED_ERROR_MESSAGE);
        }
    }

    private int validateBonus(String bonusInput) {
        try {
            int bonus = Integer.parseInt(bonusInput);

            if (bonus < LottoSettings.LOTTO_NUMBER_RANGE_START || bonus > LottoSettings.LOTTO_NUMBER_RANGE_END) {
                throw new IllegalArgumentException(ErrorMessage.BONUS_IS_NOT_IN_RANGE_ERROR_MESSAGE);
            }

            if (numbers.contains(bonus)) {
                throw new IllegalArgumentException(ErrorMessage.BONUS_IS_DUPLICATED_ERROR_MESSAGE);
            }

            return bonus;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_IS_NOT_INT_ERROR_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonus() {
        return bonus;
    }
}
