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
    List<Rank> ranks = new ArrayList<>();

    public HitResult(LottoGroup lottoGroup,
            WinningLotto winningLotto, BonusNumber bonusNumber) {
        calculate(lottoGroup, winningLotto, bonusNumber);
    }

    private void calculate(LottoGroup lottoGroup,
            WinningLotto winningLotto, BonusNumber bonusNumber) {
        int hitCount;
        initializeResult();
        for (Lotto lotto : lottoGroup.getLottoGroup()) {
            hitCount = lotto.getMatchCount(winningLotto);
            ranks.add(Rank.getRank(hitCount, lotto.contains(bonusNumber)));
        }
        updateResult(ranks);
    }

    private void initializeResult() {
        for (Rank rank : Rank.getAllRanksExceptNone()) {
            result.put(rank, 0);
        }
    }

    private void updateResult(List<Rank> ranks) {
        for (Rank rank : ranks) {
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }

    public Map<Rank, Integer> getHitResultExceptNone() {
        result.remove(Rank.NONE);
        return result;
    }
}
