package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isProperSize(numbers);
        isAllNumberUnique(numbers);
        for (Integer number : numbers) {
            isInRange(number);
        }
    }

    private void isProperSize(List<Integer> numbers) {
        if (numbers.size() != LottoNumber.TOTAL_COUNT) {
            throw new IllegalArgumentException("[ERROR]count of numbers in lotto should be" + LottoNumber.TOTAL_COUNT);
        }
    }

    private void isAllNumberUnique(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != LottoNumber.TOTAL_COUNT) {
            throw new IllegalArgumentException("[ERROR]all numbers in lotto should be unique");
        }
    }

    private void isInRange(int number) {
        if (number < LottoNumber.MIN || number > LottoNumber.MAX) {
            throw new IllegalArgumentException
                    ("[ERROR]number should be between " + LottoNumber.MIN + "and" + LottoNumber.MAX);
        }
    }
}
