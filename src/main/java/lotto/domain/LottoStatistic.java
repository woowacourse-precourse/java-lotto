package lotto.domain;

import lotto.constant.LottoConstants;

import java.util.List;
import java.util.stream.Collectors;

public class LottoStatistic {
    private final WinningLottery winningLottery;
    private final Lottos lottos;

    public LottoStatistic(WinningLottery winningLottery, Lottos generated) {
        this.winningLottery = winningLottery;
        this.lottos = generated;
    }

    public LottoScoreDto getScore() {
        List<LottoResult> scores = calculateScore();
        long three = getThree(scores);
        long four = getFour(scores);
        long five = getFive(scores);
        long fiveBonus = getFiveBonus(scores);
        long six = getSix(scores);
        double rate = getRate(three, four, five, fiveBonus, six);
        return new LottoScoreDto(three, four, five, fiveBonus, six, rate);
    }

    private List<LottoResult> calculateScore() {
        return lottos.getLottos()
                .stream().
                map(winningLottery::getResult)
                .collect(Collectors.toList());
    }

    private long getThree(List<LottoResult> scores) {
        return scores.stream()
                .filter(it -> it == LottoResult.THREE_CORRECT)
                .count();
    }

    private long getFour(List<LottoResult> scores) {
        return scores.stream()
                .filter(it -> it == LottoResult.FOUR_CORRECT)
                .count();
    }

    private long getFive(List<LottoResult> scores) {
        return scores.stream()
                .filter(it -> it == LottoResult.FIVE_CORRECT)
                .count();
    }

    private long getFiveBonus(List<LottoResult> scores) {
        return scores.stream()
                .filter(it -> it == LottoResult.FIVE_BONUS_CORRECT)
                .count();
    }

    private long getSix(List<LottoResult> scores) {
        return scores.stream()
                .filter(it -> it == LottoResult.SIX_CORRECT)
                .count();
    }

    private double getRate(long three, long four, long five, long fiveBonus, long six) {
        long total = three * LottoResult.THREE_CORRECT.money() +
                four * LottoResult.FOUR_CORRECT.money() +
                five * LottoResult.FIVE_CORRECT.money() +
                fiveBonus * LottoResult.FIVE_BONUS_CORRECT.money() +
                six * LottoResult.SIX_CORRECT.money();
        int lottoPrice = LottoConstants.LOTTO_PRICE
                .value();
        int totalCount = lottos.getLottos()
                .size();
        return (double) total / (lottoPrice * totalCount) * 100;
    }
}
