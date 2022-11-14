package lotto.domain;

import lotto.constant.LottoConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

final class LottoStatistic {
    private final WinningLotto winningLotto;
    private final Lottos lottos;

    public LottoStatistic(WinningLotto winningLotto, Lottos generated) {
        this.winningLotto = winningLotto;
        this.lottos = generated;
    }

    public LottoScoreDto calculateStatistic() {
        List<LottoResult> scores = calculateScore();
        Map<LottoPrize, Integer> lottoPrizeCount = new HashMap<>();
        lottoPrizeCount.put(LottoPrize.FIRST_PRIZE, calculateFirstPrizeCount(scores));
        lottoPrizeCount.put(LottoPrize.SECOND_PRIZE, calculateSecondPrizeCount(scores));
        lottoPrizeCount.put(LottoPrize.THIRD_PRIZE, calculateThirdPrizeCount(scores));
        lottoPrizeCount.put(LottoPrize.FOURTH_PRIZE, calculateFourthPrizeCount(scores));
        lottoPrizeCount.put(LottoPrize.FIFTH_PRIZE, calculateFifthPrizeCount(scores));

        double rate = calculateRate(lottoPrizeCount);
        return new LottoScoreDto(lottoPrizeCount, rate);
    }

    private List<LottoResult> calculateScore() {
        return lottos.toStream()
                .map(winningLotto::calculateBonusAndSameCount)
                .collect(Collectors.toList());
    }

    private int calculateFifthPrizeCount(List<LottoResult> scores) {
        return (int) scores.stream()
                .filter(LottoResult::isFifthPrize)
                .count();
    }

    private int calculateFourthPrizeCount(List<LottoResult> scores) {
        return (int) scores.stream()
                .filter(LottoResult::isFourthPrize)
                .count();
    }

    private int calculateThirdPrizeCount(List<LottoResult> scores) {
        return (int) scores.stream()
                .filter(LottoResult::isThirdPrize)
                .count();
    }

    private int calculateSecondPrizeCount(List<LottoResult> scores) {
        return (int) scores.stream()
                .filter(LottoResult::isSecondPrize)
                .count();
    }

    private int calculateFirstPrizeCount(List<LottoResult> scores) {
        return (int) scores.stream()
                .filter(LottoResult::isFirstPrize)
                .count();
    }

    private double calculateRate(Map<LottoPrize, Integer> prizeCount) {
        long totalPrize = prizeCount.keySet()
                .stream()
                .map(key -> key.getPrize() * prizeCount.get(key))
                .mapToLong(prize -> (long) prize)
                .reduce(0, Long::sum);
        int totalPurchaseAmount = LottoConstants.LOTTO_PRICE.value() * lottos.size();
        return (double) totalPrize / totalPurchaseAmount * 100;
    }
}
