package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkOutOfRange(numbers);
        checkDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkOutOfRange(List<Integer> numbers) {
        if (numbers.get(0) < 1 || numbers.get(numbers.size() - 1) > 45) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicateNumber(List<Integer> numbers) {
        int distinctSize = (int) numbers.stream()
                .distinct()
                .count();

        if (numbers.size() != distinctSize) {
            throw new IllegalArgumentException();
        }
    }

    public void printNumbers() {
        System.out.println(numbers);
    }

    public int calculateWinningCount(List<Integer> winningNumbers) {
        int winningCount = 0;
        int numberIdx = 0;
        int winningNumberIdx = 0;

        while(numberIdx < numbers.size() && winningNumberIdx < winningNumbers.size()) {
            if (isSameNumbers(numbers, winningNumbers, numberIdx, winningNumberIdx)) {
                winningCount++;
                numberIdx++;
                winningNumberIdx++;
            } else if (isBiggerThanTarget(numbers, winningNumbers, numberIdx, winningNumberIdx)) {
                winningNumberIdx++;
            } else if (isSmallerThanTarget(numbers, winningNumbers, numberIdx, winningNumberIdx)) {
                numberIdx++;
            }
        }
        return winningCount;
    }

    private boolean isSameNumbers(List<Integer> numbers, List<Integer> targetNumbers, int numberIdx, int targetNumberIdx) {
        return numbers.get(numberIdx).intValue() == targetNumbers.get(targetNumberIdx).intValue();
    }

    private boolean isBiggerThanTarget(List<Integer> numbers, List<Integer> targetNumbers, int numberIdx, int targetNumberIdx) {
        return numbers.get(numberIdx) > targetNumbers.get(targetNumberIdx);
    }

    private boolean isSmallerThanTarget(List<Integer> numbers, List<Integer> targetNumbers, int numberIdx, int targetNumberIdx) {
        return numbers.get(numberIdx) < targetNumbers.get(targetNumberIdx);
    }
}