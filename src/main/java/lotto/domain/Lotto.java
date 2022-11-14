package lotto.domain;

import lotto.data.Error;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        ExceptionHandler.checkOutOfRange(numbers);
        ExceptionHandler.checkDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.INVALID_SIZE.getMessage());
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

    public boolean isSameWithBonus(int bonus) {
        return numbers.contains(bonus);
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