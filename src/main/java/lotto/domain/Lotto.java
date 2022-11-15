package lotto.domain;

import lotto.standard.Bug;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        List<Integer> outOfRangeNumbers = new ArrayList<>(numbers);
        outOfRangeNumbers.removeAll(Bug.getRangeOfNumber());

        if (numbers.size() != Bug.RANGE) {
            throw new IllegalArgumentException(Bug.ERROR + Bug.LOTTO_MUST_RANGE_SIX);
        }
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(Bug.ERROR + Bug.LOTTO_MUST_EACH_UNIQUE);
        }
        if (!outOfRangeNumbers.isEmpty()) {
            throw new IllegalArgumentException(Bug.ERROR + Bug.LOTTO_MUST_BETWEEN_ONE_AND_FORTY_FIVE);
        }
    }

    public int checkNumbers(List<Integer> userLottoNumbers) {
        List<Integer> lottoNumbers = new ArrayList<>(userLottoNumbers);
        lottoNumbers.removeAll(numbers);
        int matchingNumber = numbers.size() - lottoNumbers.size();
        return matchingNumber;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}