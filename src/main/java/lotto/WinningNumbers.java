package lotto;

public class WinningNumbers {

    private final Lotto lotto;
    private final LottoNumber bonus;

    private WinningNumbers(Lotto lotto, LottoNumber bonus) {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private static void validate(Lotto lotto, LottoNumber bonus) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public LottoNumber getBonus() {
        return bonus;
    }

}
