package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static Lotto create() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(
                LottoEnum.MIN_NUMBER.getValue(),
                LottoEnum.MAX_NUMBER.getValue(),
                LottoEnum.WINNING_NUMBERS.getValue()
        ));
    }
}

