package lotto.user;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.Utilities;
import lotto.util.Validator;

import java.util.List;

public class Lotto {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int NUMBERS_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, NUMBERS_SIZE);
        return new Lotto(Utilities.sort(numbers));
    }

    private static void validate(List<Integer> numbers) {
        if (!Validator.isNotNull(numbers)
                || !Validator.isListInSize(numbers, NUMBERS_SIZE)
                || !LottoValidator.isNumbersNotRepeated(numbers)
                || !LottoValidator.isNumbersInRange(numbers, START_INCLUSIVE, END_INCLUSIVE)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
