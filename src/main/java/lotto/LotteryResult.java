package lotto;

import java.util.ArrayList;
import java.util.List;

public class LotteryResult {
    Lotto winningNumbers;
    int bonusNumber;
    public Ranking calcResult(List<Lotto> lottos) {
        int hitCount = 0;
        boolean bonusHit = false;
        for(Lotto userLotto : lottos) {
            hitCount = userLotto.countWinningHit(winningNumbers);
            bonusHit = userLotto.isHitted(bonusNumber);
        }
        return Ranking.getRanking(hitCount, bonusHit);
    }

}
