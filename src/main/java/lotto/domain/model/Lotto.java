package lotto.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("로또의 번호는 총 6개여야 합니다.");
        }
        if (!isValidNumber(numbers)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        Long distinctSize = numbers.stream()
                .distinct()
                .count();
        return distinctSize != NUMBER_COUNT;
    }

    private boolean isValidNumber(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(i -> MINIMUM_NUMBER <= i && i <= MAXIMUM_NUMBER);
    }

    public int size() {
        return this.numbers.size();
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

    public int getCorrectCount(Lotto lotto) {
        List<Integer> copiedList = new ArrayList<>(this.numbers);
        copiedList.retainAll(lotto.numbers);
        return copiedList.size();
    }
}
