package lotto.domain.getwin.domain;

public class Bonus {
    static final int BONUS_NUMBER_START = 1;
    static final int BONUS_NUMBER_END = 45;
    static final String ERROR_BONUS_OUT_OF_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    public final int bonus;

    public Bonus(int bonus) {
        validate(bonus);
        this.bonus = bonus;
    }

    private void validate(int bonus) {
        if (!numbersInRange(bonus)) {
            throw new IllegalArgumentException(ERROR_BONUS_OUT_OF_RANGE);
        }
    }

    private boolean numbersInRange(int bonus) {
        return ((bonus >= BONUS_NUMBER_START) && (bonus <= BONUS_NUMBER_END));
    }
}
