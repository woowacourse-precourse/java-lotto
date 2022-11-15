package lotto.data;

public class LottoNumber {
    private final Lotto lotto;
    private final int bonusNumber;

    public LottoNumber(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return this.lotto;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
