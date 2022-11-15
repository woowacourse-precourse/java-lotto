package lotto.domain;

import lotto.domain.message.ErrorMessages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = new ArrayList<>(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(ErrorMessages.LOTTO_NUM_NUMBER_ERROR.get());
            throw new IllegalArgumentException();
        }
        for (Integer num: numbers) {
            if (num > 45 || num < 1) {
                System.out.println(ErrorMessages.LOTTO_NUM_RANGE_ERROR.get());
                throw new IllegalArgumentException();
            }
            if (numbers.indexOf(num) != numbers.lastIndexOf(num)) {
                System.out.println(ErrorMessages.LOTTO_NUM_DUPLICATE_ERROR.get());
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getSameNumCount(List<Integer> otherNumbers) {
        int sameNumCount = 0;

        for (Integer num: numbers) {
            if (otherNumbers.contains(num)) {
                sameNumCount ++;
            }
        }
        return sameNumCount;
    }

    public boolean checkBonus(int bonusNum) {
        return numbers.contains(bonusNum);
    }
}
