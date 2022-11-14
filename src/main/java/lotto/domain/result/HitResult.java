package lotto.domain.result;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.lottery.BonusNumber;
import lotto.domain.lottery.Lotto;
import lotto.domain.lottery.LottoGroup;
import lotto.domain.lottery.WinningLotto;

public class HitResult {

    private final Map<Rank, Integer> result = new EnumMap<>(Rank.class);

    public HitResult(LottoGroup lottoGroup,
            WinningLotto winningLotto, BonusNumber bonusNumber) {
        initializeResult();
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottoGroup.getLottoGroup()) {
            ranks.add(calculateRank(lotto, winningLotto, bonusNumber));
        }
        updateResult(ranks);
    }

    private void initializeResult() {
        for (Rank rank : Rank.getAllRanks()) {
            result.put(rank, 0);
        }
    }

    private void updateResult(List<Rank> ranks) {
        for (Rank rank : ranks) {
            result.put(rank, result.get(rank) + 1);
        }
    }

    public Map<Rank, Integer> getHitResult() {
        return result;
    }

    public Rank calculateRank(Lotto lotto,
            WinningLotto winningLotto, BonusNumber bonusNumber) {
        int hitCount = lotto.getMatchCount(winningLotto);
        return Rank.getRank(hitCount, lotto.contains(bonusNumber));
    }
}
