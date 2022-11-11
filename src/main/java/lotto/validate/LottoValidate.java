package lotto.validate;

import java.util.List;

public class LottoValidate {
    private static final int LOTTO_SIZE = 6;
    private static final int START_NUMBER = 1;
    private static final int LAST_NUMBER = 45;

    public void validate(List<Integer> numbers) {
        lottoSizeValidate(numbers);
        lottoDuplicateValidate(numbers);
        lottoRangeValidate(numbers);
    }

    private void lottoSizeValidate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void lottoDuplicateValidate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    private void lottoRangeValidate(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < START_NUMBER || number > LAST_NUMBER) {
                throw new IllegalArgumentException();
            }
        }
    }
}
