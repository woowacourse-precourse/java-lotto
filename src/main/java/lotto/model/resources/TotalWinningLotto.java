package lotto.model.resources;

import java.util.List;

public class TotalWinningLotto {

    LottoWin lottoWin;
    BonusLotto bonusLotto;

    private TotalWinningLotto(LottoWin lottoWin, BonusLotto bonusLotto) {
        this.lottoWin = lottoWin;
        this.bonusLotto = bonusLotto;
    }

    public static TotalWinningLotto of(LottoWin lottoWin, BonusLotto bonusLotto) {
        return new TotalWinningLotto(lottoWin, bonusLotto);
    }

    public List<Integer> getWinningLotto() {
        return lottoWin.getNumbers();
    }

    public int getBonusLotto() {
        return bonusLotto.getBonusNum();
    }
}
