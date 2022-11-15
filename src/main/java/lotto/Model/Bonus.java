package lotto.Model;

import java.util.Arrays;

import lotto.resources.Sentence;
import lotto.resources.Constants;
import lotto.resources.ExceptionCatcher;

public class Bonus {

    public static void inputValidity(String input, Lotto answer) {
        if (checkNum(input.trim()) == Constants.ERROR_CASE.getValue() ||
            checkInRange(input.trim()) == Constants.ERROR_CASE.getValue() ||
            checkNotInWin(checkInRange(input.trim()), answer) == Constants.ERROR_CASE.getValue()) {
        }
    }

    private static int checkNum(String input) {
        long count = input.chars().filter(Character::isDigit).count();
        try {
            if (count != input.length()) {
                throw new IllegalArgumentException(Sentence.BONUS_NOT_NUMERIC.getValue());
            }
        } catch (IllegalArgumentException e) {
            throw new ExceptionCatcher(Sentence.BONUS_NOT_NUMERIC.getValue());
        }
        return Constants.CORRECT_CASE.getValue();
    }

    private static Integer checkInRange(String input) {

        try {
            if (!(Long.parseLong(input) >= Constants.FROM.getValue() &&
                    Long.parseLong(input) <= Constants.TO.getValue())) {
                throw new IllegalArgumentException(Sentence.BONUS_OUT_OF_RANGE.getValue());
            }
        } catch (IllegalArgumentException e) {
            throw new ExceptionCatcher(Sentence.BONUS_OUT_OF_RANGE.getValue());
        }
        return Integer.parseInt(input);
    }

    private static Integer checkNotInWin(Integer input, Lotto answer) {

        Lotto bonusLotto = new Lotto(Arrays.asList(input, 0, 0, 0, 0, 0));
        try {
            if (LottoCalculator.getCountOfSameNumber(bonusLotto, answer) == Constants.CORRECT_CASE.getValue()) {
                throw new IllegalArgumentException(Sentence.BONUS_IN_ANSWER.getValue());
            }
        } catch (IllegalArgumentException e) {
            throw new ExceptionCatcher(Sentence.BONUS_IN_ANSWER.getValue());
        }
        return Constants.CORRECT_CASE.getValue();
    }
}