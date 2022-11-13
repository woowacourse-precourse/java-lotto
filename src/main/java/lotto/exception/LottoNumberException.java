package lotto.exception;

import java.util.List;

public class LottoNumberException {
    private static final String LIST_SIZE = "[ERROR] 크기가 6이 아닙니다.";
    private static final String MAX_AND_MIN = "[ERROR] 로또의 최대 최소 값이 맞지 않습니다.";
    private static final String DUPLICATED = "[ERROR] 중복된 값이 있습니다.";
    public void lottoNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LIST_SIZE);
        }
    }

    public void lottoNumberMaxMin(List<Integer> numbers) {
        for (Integer num : numbers) {
            if (num > 45 || num < 1) {
                throw new IllegalArgumentException(MAX_AND_MIN);
            }
        }
    }

    public void lottoNumberDuplicated(List<Integer> numbers) {
        for (Integer num : numbers) {
            if (numbers.indexOf(num) != numbers.lastIndexOf(num)) {
                throw new IllegalArgumentException(DUPLICATED);
            }
        }
    }

    public void fullException(List<Integer> numbers) {
        lottoNumberSize(numbers);
        lottoNumberDuplicated(numbers);
        lottoNumberMaxMin(numbers);
    }

    public void bonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber))
            throw new IllegalArgumentException(DUPLICATED);
    }
}
