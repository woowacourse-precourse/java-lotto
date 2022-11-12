package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자가 6개여야 합니다.");
        }
        if (checkDuplicateInNumbers(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에는 중복이 있어선 안 됩니다.");
        }
        if (!isNumbersInRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 숫자 범위는 1부터 45까지 입니다.");
        }
    }

    private boolean checkDuplicateInNumbers(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    private boolean isNumbersInRange(List<Integer> numbers) {
        return numbers.stream().allMatch(num -> MIN_LOTTO_NUMBER <= num && num <= MAX_LOTTO_NUMBER);
    }

    public int countMatch(Lotto winningNumbers) {
        return (int) numbers
                .stream()
                .filter(winningNumbers::containNumber)
                .count();
    }

    public boolean containNumber(Integer number) {
        return numbers.contains(number);
    }
}