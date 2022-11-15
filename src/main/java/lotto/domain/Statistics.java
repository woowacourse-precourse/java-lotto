package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private static final int FIVE_MATCHING_LOTTO_NUMBERS = 5;
    private static final int COUNT_WINNING_LOTTO_BEFORE_RESULT = 0;
    private static final int COUNTING_WINNING_LOTTO = 1;
    private static final int PERCENT = 100;

    private Map<Rank, Integer> lottosResult;

    public Statistics(List<Lotto> lottos, WinningLotto winningLotto) {
        lottosResult = new LinkedHashMap<>();
        initLottoResult();
        createStatistics(lottos, winningLotto);
    }

    private void initLottoResult() {
        for (Rank rank : Rank.values()) {
            lottosResult.put(rank, COUNT_WINNING_LOTTO_BEFORE_RESULT);
        }
    }

    public double getYield(int money) {
        double totalWinnings = lottosResult.entrySet().stream()
                .mapToDouble(rankEntry -> rankEntry.getKey().getReward() * rankEntry.getValue())
                .sum();
        return totalWinnings * PERCENT / money;
    }

    private void createStatistics(List<Lotto> lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            Rank lottoRank = getLottoResult(lotto, winningLotto);
            updateLottosResult(lottoRank);
        }
    }

    private void updateLottosResult(Rank lottoRank) {
        lottosResult.put(lottoRank, lottosResult.get(lottoRank) + COUNTING_WINNING_LOTTO);
    }

    private Rank getLottoResult(Lotto lotto, WinningLotto winningLotto) {
        int matchingCnt = compareNumbers(lotto, winningLotto);
        boolean bonusBall = false;
        if (matchingCnt == FIVE_MATCHING_LOTTO_NUMBERS) {
            bonusBall = compareBonusNumber(lotto, winningLotto.getBonusBall());
        }
        return Rank.getRank(matchingCnt, bonusBall);
    }

    private boolean compareBonusNumber(Lotto lotto, int bonusBall) {
        return lotto.getNumbers().contains(bonusBall);
    }

    private int compareNumbers(Lotto lotto, WinningLotto winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }

    public Map<Rank, Integer> getLottosResult() {
        return lottosResult;
    }
}
