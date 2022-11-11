package lotto.store;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> lottoNumbers = new ArrayList<>(numbers);
        Collections.sort(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public String toString() {
        return String.valueOf(numbers);
    }

    public int compareWinNumbers(List<Integer> winNumbers) {
        List<Integer> copyNumbers = new ArrayList<>(numbers);
        copyNumbers.retainAll(winNumbers);
        return copyNumbers.size();
    }

    public boolean compareBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
