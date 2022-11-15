package lotto;

public class WinningNumbers {

    private final Lotto lotto;
    private final LottoNumber bonus;

    private WinningNumbers(Lotto lotto, LottoNumber bonus) {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }
}
