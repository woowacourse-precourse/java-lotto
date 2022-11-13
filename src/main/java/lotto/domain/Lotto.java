package lotto.domain;

import lotto.exception.LottoException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoException.validateLotto(numbers);
        this.numbers = numbers;
    }

    // TODO: 추가 기능 구현
    public int getCountMatchingNumber(List<Integer> numbers) {
        int count = 0;

        for (Integer number : numbers) {
            if (this.numbers.contains(number)) {
                count++;
            }
        }

        return count;
    }

    public boolean hasNumber(int number) {
        if (numbers.contains(number)) return true;
        return false;
    }

    public String toString() {
        List<Integer> cloneNumber = new ArrayList<>();
        cloneNumber.addAll(numbers);
        Collections.sort(cloneNumber);
        return cloneNumber.toString();
    }
}
