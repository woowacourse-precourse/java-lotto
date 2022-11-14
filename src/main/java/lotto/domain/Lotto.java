package lotto.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Constants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        this.numbers.sort(Comparator.naturalOrder());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(Constants.IS_NOT_LOTTO_NUMBERS_SIZE_ERROR_MESSAGE);
        }
    }

    public int getSameNumberCount(Lotto winningLotto, Lotto userLotto) {
        int sameCnt = 0;
        for (Integer number : userLotto.numbers) {
            if (winningLotto.numbers.contains(number)) {
                sameCnt++;
            }
        }
        return sameCnt;
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(Constants.ISSUED_LOTTO_NUMBERS_SEPARATOR));
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
