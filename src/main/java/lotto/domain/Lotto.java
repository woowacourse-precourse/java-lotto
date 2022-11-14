package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateNumbers(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    public void duplicateWinningNumbersAndGeneratorNumbers(
            List<List<Integer>> generatorNumbers, int number) {
        int count = 0;
        for (int i = 0; i < generatorNumbers.size(); i++) {
            count = 0;
            count = duplicateWinningNumbersAndGeneratorNumbersInternal(generatorNumbers, i, count);
            PrizeMoney.getMatchingNumbersCount(count,
                    isBonusNumberInGeneratorNumbers(generatorNumbers, number, i));
        }
    }

    public int duplicateWinningNumbersAndGeneratorNumbersInternal(
            List<List<Integer>> generatorNumbers, int i, int count) {
        for (int j = 0; j < generatorNumbers.get(i).size(); j++) {
            if (numbers.contains(generatorNumbers.get(i).get(j))) {
                count++;
            }
        }
        return count;
    }

    public boolean isBonusNumberInGeneratorNumbers(
            List<List<Integer>> generatorNumbers, int bonusNumber, int order) {
        for (int i = 0; i < generatorNumbers.get(order).size(); i++) {
            if (generatorNumbers.get(order).contains(bonusNumber)) {
                return true;
            }
        }
        return false;
    }

    public void validateDuplicateWinningNumbersAndBonusNumber(int bonusNumber) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == bonusNumber) {
                throw new IllegalArgumentException("[ERROR] 로또 당첨 번호와 로또 보너스 번호가 중복됩니다.");
            }
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 입력된 로또 번호가 6자리가 아닙니다.");
        }
    }

    private void validateNumbers(List<Integer> winningNumbers) {
        for (int i = 0; i < winningNumbers.size(); i++) {
            if ((winningNumbers.get(i) < Constant.MIN_NUMBER)
                    || (winningNumbers.get(i) > Constant.MAX_NUMBER)) {
                throw new IllegalArgumentException("[ERROR] 입력된 로또 번호가 1 ~ 45 사이가 아닙니다.");
            }
        }
    }

    private void validateDuplicateNumbers(List<Integer> winningNumbers) {
        for (int i = 0; i < winningNumbers.size(); i++) {
            validateDuplicateNumberFor(winningNumbers, i);
        }
    }

    private void validateDuplicateNumberFor(List<Integer> winningNumbers, int i) {
        for (int j = i + 1; j < winningNumbers.size(); j++) {
            if (winningNumbers.get(i).equals(winningNumbers.get(j))) {
                throw new IllegalArgumentException("[ERROR] 입력된 로또 번호 중 중복되는 숫자가 있습니다.");
            }
        }
    }
}
