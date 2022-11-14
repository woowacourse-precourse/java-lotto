package lotto;

public class Bonus {
    final int bonus;

    Bonus(int bonus) {
        validate(bonus);
        this.bonus = bonus;
    }

    private void validate(int bonus) {
        if (!numbersInRange(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private boolean numbersInRange(int bonus) {
        return (bonus >= 1) && (bonus <= 45);
    }
}
