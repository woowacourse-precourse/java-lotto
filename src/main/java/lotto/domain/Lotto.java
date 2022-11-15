package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.ErrorHandler;
import lotto.util.ErrorMessage;
import lotto.util.Utilities;
import lotto.util.Validator;

import java.util.List;

import static lotto.util.Constant.*;

public class Lotto {
    private static final int NUMBERS_SIZE = 6;
    private static final int BONUS_SCORE = 1;
    private static final int BONUS_SCORELESS = 0;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.validateNotNull(numbers);
        LottoValidator.validateNumbersSize(numbers);
        LottoValidator.validateNumbersNotRepeated(numbers);
        LottoValidator.validateNumbersInRange(numbers);
    }

    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, NUMBERS_SIZE);
        return new Lotto(Utilities.sort(numbers));
    }

    public static Lotto generate(String draw) {
        return new Lotto(Utilities.convertToList(draw));
    }

    public static int generate(Lotto draw, String bonus) {
        validateBonus(draw, bonus);
        return Integer.parseInt(bonus);
    }

    public static void validateBonus(Lotto draw, String bonus) {
        BonusValidator.validateInteger(bonus);
        BonusValidator.validateBonusInRange(Integer.parseInt(bonus), START_INCLUSIVE, END_INCLUSIVE);
        BonusValidator.validateBonusNotRepeated(draw, Integer.parseInt(bonus));
    }

    public int calculateDraw(Lotto draw) {
        return (int) numbers
                .stream()
                .filter(draw.numbers::contains)
                .count();
    }

    public int calculateBonus(Lotto draw, int bonus) {
        if ((int) numbers
                .stream()
                .filter(draw.numbers::contains)
                .count() == FIVE
                && numbers.contains(bonus)) {
            return BONUS_SCORE;
        }
        return BONUS_SCORELESS;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    static class LottoValidator extends Validator {
        public static void validateNumbersSize(List<Integer> list) {
            if (list.size() != NUMBERS_SIZE) {
                ErrorHandler.throwException(ErrorMessage.LOTTO_SIZE_EXCEEDED);
            }
        }

        public static void validateNumbersNotRepeated(List<Integer> numbers) {
            if (numbers
                    .stream()
                    .distinct()
                    .count() != numbers.size()) {
                ErrorHandler.throwException(ErrorMessage.LOTTO_NUMBERS_REPEATED);
            }
        }

        public static void validateNumbersInRange(List<Integer> numbers) {
            if (numbers
                    .stream()
                    .anyMatch(number -> (number < START_INCLUSIVE || number > END_INCLUSIVE))) {
                ErrorHandler.throwException(ErrorMessage.LOTTO_NUMBERS_NOT_IN_RANGE);
            }
        }
    }

    static class BonusValidator extends Validator {
        public static void validateBonusInRange(int bonus, int startInclusive, int endInclusive) {
            if (bonus < startInclusive
                    || bonus > endInclusive) {
                ErrorHandler.throwException(ErrorMessage.LOTTO_NUMBERS_NOT_IN_RANGE);
            }
        }

        public static void validateBonusNotRepeated(Lotto draw, int bonus) {
            if (draw.numbers.contains(bonus)) {
                ErrorHandler.throwException(ErrorMessage.BONUS_NUMBER_REPEATED);
            }
        }
    }
}
