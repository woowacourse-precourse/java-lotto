package lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        // 6자리 숫자이어야 한다.
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Constants.LOTTO_NUMBERS_LEN_EXCEPTION);
        }

        // 1부터 45까지 중복되지 않은 숫자이어야 한다.
        boolean[] duplicateCheck = new boolean[Constants.LOTTO_END_NUMBER + 1];
        for (Integer num : numbers) {
            if (num < Constants.LOTTO_START_NUMBER || num > Constants.LOTTO_END_NUMBER) {
                throw new IllegalArgumentException(Constants.LOTTO_NUMBERS_RANGE_EXCEPTION);
            }

            if (duplicateCheck[num]) {
                throw new IllegalArgumentException(Constants.LOTTO_NUMBERS_DUPLICATE_EXCEPTION);
            }
            duplicateCheck[num] = true;
        }
    }

    // TODO: 추가 기능 구현
}
