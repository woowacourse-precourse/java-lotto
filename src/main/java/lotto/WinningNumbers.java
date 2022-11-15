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

    public static WinningNumbers of(final Lotto lotto, LottoNumber bonus) {
        return new WinningNumbers(lotto, bonus);
    }

    public LottoNumber getBonus() {
        return bonus;
    }

    public boolean contains(Integer number) {
        return lotto.getNumbers().contains(number);
    }
}

