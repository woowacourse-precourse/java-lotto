package lotto.service;

import lotto.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.User;
import lotto.domain.WinningLotto;

public class LottoService {

    public void calculateLottoRanks(User user, WinningLotto winningLotto) {
        for (Lotto purchasedLotto : user.getLottos()) {
            calculateLottoRank(purchasedLotto, winningLotto);
        }
    }

    private LottoRank calculateLottoRank(Lotto purchasedLotto, WinningLotto winningLotto) {
        return LottoRank.FIRST;
    }
}
