package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    private final List<Integer> numbers;
    private int bonus;

    public WinningLotto(List<Integer> numbers, int bonus) {
        validateNumbers(numbers);
        this.numbers = numbers;
        validateBonus(bonus);
        this.bonus = bonus;
    }

    private void validateNumbers(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수가 6개가 아닙니다.");
        }

        Set<Integer> setOfNumber = new HashSet<>(numbers);
        if(setOfNumber.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }

        numbers.forEach(num ->
        { if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        });
    }

    private void validateBonus(int bonus) {
        if(bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여 합니다.");
        }
        if((this.numbers).contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

    public int getBonus() {
        return bonus;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
