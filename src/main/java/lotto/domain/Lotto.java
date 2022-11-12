package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateNumbers(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 입력된 로또 번호가 6자리가 아닙니다.");
        }
    }

    private void validateNumbers(List<Integer> winningNumbers) {
        for (int i = 0; i < winningNumbers.size(); i++) {
            if ((winningNumbers.get(i) < MIN_NUMBER)
                    || (winningNumbers.get(i) > MAX_NUMBER)) {
                throw new IllegalArgumentException("[ERROR] 입력된 로또 번호가 1 ~ 45 사이가 아닙니다.");
            }
        }
    }

    private void validateDuplicateNumbers(List<Integer> winningNumbers) {
        int count=0;
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
