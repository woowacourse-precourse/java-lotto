package lotto;

import java.util.List;

public class LotteryResult {
    Lotto winningNumbers;
    int bonusNumber;
    public Rank calcResult(List<Lotto> lottos) {
        int hitCount = 0;
        boolean bonusHit = false;
        for(Lotto userLotto : lottos) {
            hitCount = userLotto.countMatchedNumber(winningNumbers);
            bonusHit = userLotto.isHitted(bonusNumber);
        }
        return Rank.getRanking(hitCount, bonusHit);
    }

}
