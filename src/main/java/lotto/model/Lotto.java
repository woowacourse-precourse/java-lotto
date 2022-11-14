package lotto.model;

import java.util.List;

public class Lotto {
    private static final int ONE = 1;
    private static final String ERROR_INCORRECT_COUNT = "[ERROR] 로또 번호는 1~45까지 중 서로 다른 6자리 수여야 합니다.";
    private static final String ERROR_DUPLICATE = "[ERROR] 로또 번호가 중복입니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        bubbleSort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_INCORRECT_COUNT);
        }

        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void bubbleSort(List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size() - i; j++) {
                swapNumber(numbers, j, j + ONE);
            }
        }
    }

    private void swapNumber(List<Integer> numbers, int thisIndex, int nextIndex) {
        int thisNumber = numbers.get(thisIndex).intValue();
        int nextNumber = numbers.get(nextIndex).intValue();
        if (thisNumber > nextNumber) {
            numbers.set(thisIndex, nextNumber);
            numbers.set(nextIndex, thisNumber);
        }
    }
}
