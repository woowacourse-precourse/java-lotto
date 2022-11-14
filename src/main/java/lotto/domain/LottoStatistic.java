package lotto.domain;

import lotto.constant.LottoConstants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

final class LottoStatistic {
    private static final int TO_PERCENT = 100;
    private final WinningLotto winningLotto;
    private final Lottos lottos;

    public LottoStatistic(WinningLotto winningLotto, Lottos generated) {
        this.winningLotto = winningLotto;
        this.lottos = generated;
    }

    public LottoScoreDto calculateStatistic() {
        final List<LottoResult> scores = calculateScore();
        final Map<LottoPrize, Integer> lottoPrizeCount = new HashMap<>();
        Arrays.stream(LottoPrize.values())
                .forEach(prize -> lottoPrizeCount.put(prize, calculatePrizeCount(scores, prize)));

        final double rate = calculateRate(lottoPrizeCount);
        return new LottoScoreDto(lottoPrizeCount, rate);
    }

    private List<LottoResult> calculateScore() {
        return lottos.toStream()
                .map(winningLotto::calculateBonusAndSameCount)
                .collect(Collectors.toList());
    }

    private int calculatePrizeCount(List<LottoResult> scores, LottoPrize expected) {
        return (int) scores.stream()
                .filter(it -> it.calculatePrize() == expected)
                .count();
    }

    private double calculateRate(Map<LottoPrize, Integer> prizeCount) {
        final long totalPrize = prizeCount.keySet()
                .stream()
                .map(key -> key.getPrize() * prizeCount.get(key))
                .mapToLong(prize -> (long) prize)
                .reduce(0, Long::sum);
        final int totalPurchaseAmount = LottoConstants.LOTTO_PRICE.value() * lottos.size();
        return (double) totalPrize / totalPurchaseAmount * TO_PERCENT;
    }
}
