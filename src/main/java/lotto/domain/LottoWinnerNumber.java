package lotto.domain;

public class LottoWinnerNumber {
    private Lotto lotto;
    private int bonusNumber;

    public LottoWinnerNumber(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }
}
