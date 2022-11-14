package lotto.domain;

import java.util.List;

public class Win {
    private final List<Integer> numbers;
    private int bonus;

    public Win(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void setBonus(int bonus) {
        validate(bonus);
        this.bonus = bonus;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않은 숫자 6개여야 합니다.");
        }
    }

    private void validate(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 중복되지 않은 숫자여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonus() {
        return bonus;
    }
}
