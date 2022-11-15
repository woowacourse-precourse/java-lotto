package lotto.domain;

import java.util.List;

public class WinningNumbers extends Lotto {
    private List<Integer> numbers;
    private int bonus;

    public WinningNumbers(List<Integer> numbers, int bonus) {
        super(numbers);
        this.numbers = numbers;

        validateBonus(bonus);
        this.bonus = bonus;
    }

    private void validateBonus(int bonus) {
        if (this.numbers.contains(bonus)) {
            System.out.println("[ERROR] 보너스 번호는 로또 번호와 중복이 없어야 합니다.");
            throw new IllegalArgumentException();
        }
        if (bonus < 1 || bonus > 45) {
            System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 자연수여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
