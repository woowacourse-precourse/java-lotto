package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class WinningLotto extends Lotto {
    private final int bonusNumber;
    private final List<Integer> lottoRank;

    public WinningLotto(List<Integer> lotto, int bonusNumber) {
        super(lotto);
        this.bonusNumber = bonusNumber;
        this.lottoRank = Arrays.asList(0, 0, 0, 0, 0, 0);
    }

    public void compareLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            compareLotto(lotto);
        }
    }

    public void compareLotto(Lotto lotto) {
        int count = lottoContainsCount(lotto.getLotto());
        LottoRank rank = LottoRank.getLottoRankByCorrectNumberCount(lotto, bonusNumber, count);
        int rankIndex = rank.ordinal();
        lottoRank.set(rankIndex, lottoRank.get(rankIndex) + 1);
    }

    public int lottoContainsCount(List<Integer> lotto) {
        int count = 0;
        for (Integer number : lotto) {
            if (this.lotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public List<Integer> getLottoRank() {
        return lottoRank;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    }
}
