package lotto.domain;

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

    public int lottoChecker() {

    }

    private int compareNumber(List<Integer> winNumbers, List<Integer> lottoNumbers) {
        int winCount = 0;
        for (Integer winNumber: winNumbers) {
            if (lottoNumbers.contains(winNumber)) {
               winCount++;
            }
        }
        return winCount;
    }

    private Boolean secondPlaceCheck() {

    }
}
