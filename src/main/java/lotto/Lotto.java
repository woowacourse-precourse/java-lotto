package lotto;

import java.util.ArrayList;
import java.util.List;

/* 로또 번호의 Type으로 사용되는 클래스입니다 */

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 숫자는 6개만 허용합니다");
        }
        List<Integer> duplication = new ArrayList<>();
        for (int number : numbers) {
            if (duplication.contains(number)) {
                throw new IllegalArgumentException("로또 번호에 중복되는 숫자가 있습니다");
            }
            if (!(number >= 1 && number <= 45)) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            duplication.add(number);
        }
    }

    public int countMatch(Lotto lotto) {
        int match = 0;
        for (int number : lotto.getNumbers()) {
            if (numbers.contains(number)) {
                match++;
            }
        }

        return match;
    }

    public boolean hasBonusNumber(Bonus bonus) {
        return numbers.contains(bonus.getBonus());
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
