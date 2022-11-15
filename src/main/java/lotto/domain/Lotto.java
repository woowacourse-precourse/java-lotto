package lotto.domain;

import static lotto.Constants.ISSUED_LOTTO_NUMBERS_SEPARATOR;
import static lotto.Constants.IS_NOT_LOTTO_NUMBERS_SIZE_ERROR_MESSAGE;
import static lotto.Constants.LOTTO_NUMBERS_ARE_DUPLICATED_ERROR_MESSAGE;
import static lotto.Constants.LOTTO_NUMBERS_SIZE;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        this.numbers.sort(Comparator.naturalOrder());
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(IS_NOT_LOTTO_NUMBERS_SIZE_ERROR_MESSAGE);
        }
        Set<Integer> checkNumbers = new HashSet<>(numbers);
        if (checkNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_ARE_DUPLICATED_ERROR_MESSAGE);
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
                .collect(Collectors.joining(ISSUED_LOTTO_NUMBERS_SEPARATOR));
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
