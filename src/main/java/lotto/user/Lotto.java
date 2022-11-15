package lotto.user;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.Utilities;

import java.util.List;

public class Lotto {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int NUMBERS_SIZE = 6;
    private static final int BONUS_SCORE = 1;
    private static final int BONUS_SCORELESS = 0;
    private static final int BONUS_COUNT = 4;

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

    public static Lotto generate(String numbers) {
        return new Lotto(Utilities.convertToList(numbers));
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
                .count() == BONUS_COUNT
                && numbers.contains(bonus)) {
            return BONUS_SCORE;
        }
        return BONUS_SCORELESS;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
