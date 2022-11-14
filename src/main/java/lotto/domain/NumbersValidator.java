package lotto.domain;


import static lotto.domain.ErrorMessage.INVALID_BONUS_NUMBER;
import static lotto.domain.ErrorMessage.INVALID_LOTTO_NUMBER;
import static lotto.domain.ErrorMessage.INVALID_MONEY;
import static lotto.domain.ErrorMessage.NOT_A_NUMBER;
import static lotto.domain.ErrorMessage.PREFIX;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class NumbersValidator {

    public static void validateWinningNumber(List<Integer> numbers, int bonusNumber) {
        validateLotto(numbers);

        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(PREFIX.getMsg() + INVALID_BONUS_NUMBER.getMsg());
        }

    }

    public static void validateLotto(List<Integer> numbers) {
        if (numbers.size() != Lotto.SIZE
                || isOverlapping(numbers)) {
            throw new IllegalArgumentException(PREFIX.getMsg() + INVALID_LOTTO_NUMBER.getMsg());
        }
    }

    private static boolean isOverlapping(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    public static void validateMoney(int money) {
        if (!Objects.equals(money % LottoMachine.MONEY_UNIT, 0)) {
            throw new IllegalArgumentException(PREFIX.getMsg() + INVALID_MONEY.getMsg());
        }
    }

    public static void isNumeric(String input) {
        if (!input.chars().mapToObj(i -> (char) i)
                .allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(PREFIX.getMsg() + NOT_A_NUMBER.getMsg());
        }
    }

    public static void isNumerics(String[] inputs) {
        Arrays.stream(inputs)
                .forEach(NumbersValidator::isNumeric);
    }
}
