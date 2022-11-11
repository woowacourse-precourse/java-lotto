package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public Lotto creatRandom() {
        List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_SIZE);

        return new Lotto(uniqueNumbers);
    }
}
