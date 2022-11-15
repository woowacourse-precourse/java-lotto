package lotto;

import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void printLottoNumbers() {
        System.out.println(Arrays.deepToString(numbers.toArray()));
    }

    public int calculateLotto(List<Integer> winningNumbers, int bonusNumber) {
        numbers.retainAll(winningNumbers);
        int score = numbers.size();
        if (score == 5 && numbers.contains(bonusNumber)) {
            score = 7;
        }
        return score;
    }
}
