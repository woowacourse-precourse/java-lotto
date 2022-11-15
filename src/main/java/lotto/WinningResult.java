package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningResult {
    public List<LottoRating> checkAllLotto(WinningLotto winningLotto, List<Lotto> lottos) {
        List<LottoRating> winningResult = new ArrayList<>();
        for (Lotto lotto : lottos) {
            LottoRating lottoRating = check(winningLotto, lotto);
            if (lottoRating != LottoRating.NOTHING) {
                winningResult.add(lottoRating);
            }
        }

        return winningResult;
    }

    public LottoRating check(WinningLotto winningLotto, Lotto lotto) {
        boolean bonusNumber = lotto.getNumbers().contains(winningLotto.getBonusNumber());
        int prizeOfMatch = 0;

        for (Integer number : lotto.getNumbers()) {
            if (winningLotto.getNumber().getNumbers().contains(number)) {
                prizeOfMatch++;
            }
        }
        return LottoRating.find(prizeOfMatch, bonusNumber);
    }


}
