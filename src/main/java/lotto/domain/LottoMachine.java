package lotto.domain;


public class LottoMachine {

    private WinningLotto winningLotto;

    public LottoMachine(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public LottoPrize compareWinningLotto(Lotto lotto) {
        int count = winningLotto.matchCount(lotto);
        boolean matchBonusNumber = false;
        if (count == 5) {
            matchBonusNumber = winningLotto.isMatchBonusNumber(lotto);
        }
        return LottoPrize.getPrize(count, matchBonusNumber);
    }

}
