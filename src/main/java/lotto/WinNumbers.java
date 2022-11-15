package lotto;

public class WinNumbers {
    private static final String BONUS_DUPLICATED_ERROR_MESSAGE = "보너스 번호는 로또 번호와 중복될 수 없습니다.";

    private final Lotto lotto;
    private final LottoNumber bonus;

    WinNumbers(final Lotto lotto, LottoNumber bonus) {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private static void validate(Lotto lotto, LottoNumber bonus) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException(BONUS_DUPLICATED_ERROR_MESSAGE);
        }
    }

    public boolean contains(final LottoNumber number) {
        return lotto.contains(number);
    }

    public LottoNumber getBonus() {
        return bonus;
    }
}