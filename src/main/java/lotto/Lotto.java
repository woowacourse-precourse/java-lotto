package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.LottoResult.checkRanking;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        this.numbers.sort(Integer::compareTo);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 6개가 아닙니다.");
        }

        if (numbers.stream()
                .distinct()
                .count() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
    }

    public LottoResult getResult(int[] winningNumbers, int bonusNumber) {
        int correct = 0;
        for (int winningNumber : winningNumbers) {
            if (numbers.contains(winningNumber)) {
                correct++;
            }
        }
        boolean bonus = numbers.contains(bonusNumber);
        return checkRanking(correct, bonus);
    }
}
