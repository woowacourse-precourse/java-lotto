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
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 여섯 자리가 아닙니다.");
        }
    }

    private void lottoDuplicateValidate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
        }
    }

    private void lottoRangeValidate(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < START_NUMBER || number > LAST_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호가 범위 밖의 숫자입니다.");
            }
        }
    }
}
