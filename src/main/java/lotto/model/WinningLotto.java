package lotto.model;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoPrize compareLotto(Lotto lotto) {
        int countMatch = lotto.countMatch(winningLotto);
        boolean bonusMatch = lotto.containLottoNumber(bonusNumber);
        return
    }
}
