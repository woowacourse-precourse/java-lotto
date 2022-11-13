package lotto.domain;

import lotto.constant.LottoConstants;

import java.util.List;
import java.util.stream.Collectors;

final class LottoStatistic {
    private final WinningLotto winningLotto;
    private final Lottos lottos;

    public LottoStatistic(WinningLotto winningLotto, Lottos generated) {
        this.winningLotto = winningLotto;
        this.lottos = generated;
    }

    public LottoScoreDto getScore() {
        List<LottoResult> scores = calculateScore();
        int three = getThree(scores);
        int four = getFour(scores);
        int five = getFive(scores);
        int fiveBonus = getFiveBonus(scores);
        int six = getSix(scores);
        double rate = getRate(three, four, five, fiveBonus, six);
        return new LottoScoreDto(three, four, five, fiveBonus, six, rate);
    }

    private List<LottoResult> calculateScore() {
        return lottos.toStream()
                .map(winningLotto::getResult)
                .collect(Collectors.toList());
    }

    private int getThree(List<LottoResult> scores) {
        return (int) scores.stream()
                .filter(it -> it == LottoResult.THREE_CORRECT)
                .count();
    }

    private int getFour(List<LottoResult> scores) {
        return (int) scores.stream()
                .filter(it -> it == LottoResult.FOUR_CORRECT)
                .count();
    }

    private int getFive(List<LottoResult> scores) {
        return (int) scores.stream()
                .filter(it -> it == LottoResult.FIVE_CORRECT)
                .count();
    }

    private int getFiveBonus(List<LottoResult> scores) {
        return (int) scores.stream()
                .filter(it -> it == LottoResult.FIVE_BONUS_CORRECT)
                .count();
    }

    private int getSix(List<LottoResult> scores) {
        return (int) scores.stream()
                .filter(it -> it == LottoResult.SIX_CORRECT)
                .count();
    }

    private double getRate(int three, int four, int five, int fiveBonus, int six) {
        double total = three * LottoResult.THREE_CORRECT.money() +
                four * LottoResult.FOUR_CORRECT.money() +
                five * LottoResult.FIVE_CORRECT.money() +
                fiveBonus * LottoResult.FIVE_BONUS_CORRECT.money() +
                six * LottoResult.SIX_CORRECT.money();
        int lottoPrice = LottoConstants.LOTTO_PRICE.value();
        int totalCount = lottos.size();
        return total / (lottoPrice * totalCount) * 100;
    }
}
