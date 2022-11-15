package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String LOTTO_NUMBER_COUNT_ERROR_MESSAGE = "[ERROR] 당첨 번호는 6개입니다.";
    private static final String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String LOTTO_NUMBER_DUPLICATED_ERROR_MESSAGE = "[ERROR] 중복된 로또 번호가 존재합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        sortedNumbers.sort(Integer::compareTo);
        this.numbers = sortedNumbers;
    }

    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkRangeAndDuplicate(numbers);
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR_MESSAGE);
        }
    }

    private void checkRangeAndDuplicate(List<Integer> numbers) {
        Set<Integer> checkDuplicatedNumbers = new HashSet<>();

        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            int number = numbers.get(i);

            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
            }

            checkDuplicatedNumbers.add(number);

            if (checkDuplicatedNumbers.size() != i + 1) {
                throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED_ERROR_MESSAGE);
            }
        }
    }

    public int matchWithWinningNumber(Lotto winningNumber) {
        int matchCount = 0;

        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            int number = winningNumber.get(i);

            if (this.contains(number)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    public int get(int index) {
        return numbers.get(index);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
