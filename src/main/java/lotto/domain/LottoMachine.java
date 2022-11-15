package lotto.domain;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {

    private WinningLotto winningLotto;

    public LottoMachine(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public LottoPrize compareWinningLotto(Lotto lotto) {
        int count = winningLotto.matchCount(lotto);
        boolean matchBonusNumber = false;
        if (count == LottoPrize.SECOND.getMatchCount()) {
            matchBonusNumber = winningLotto.isMatchBonusNumber(lotto);
        }
        return LottoPrize.getPrize(count, matchBonusNumber);
    }

    public List<LottoPrize> getPrizeResult(Lottos lottos) {
        return lottos.mapToLottoPrize(this::compareWinningLotto);
    }

    public Map<LottoPrize, Integer> getPrizeCount(Lottos lottos) {
        Map<LottoPrize, Integer> prizeResult = new HashMap<>();
        for (LottoPrize lottoPrize : getPrizeResult(lottos)) {
            prizeResult.put(lottoPrize, prizeResult.getOrDefault(lottoPrize, 0) + 1);
        }
        return prizeResult;
    }

}
