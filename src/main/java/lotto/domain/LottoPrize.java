package lotto.domain;

import lotto.util.MessageUtil;

import java.util.List;
import java.util.function.Predicate;

import static lotto.constant.LottoPrice.*;

public class LottoPrize {

    private final MessageUtil messageUtil = new MessageUtil();

    private final LottoResult lottoResult = new LottoResult();

    private final LottoWinningNumber winningNumInfo;

    public LottoPrize(LottoWinningNumber lottoWinningNumber) {
        this.winningNumInfo = lottoWinningNumber;
    }

    public void getLottoStats(List<Lotto> userLottos, int purchaseAmount) {
        messageUtil.printWinningStats();

        for (Lotto userLotto : userLottos) {
            List<Integer> userLottoNums = userLotto.getLottoNumbers();
            int matchCount = getMatchCount(userLottoNums);
            addMatchCount(checkBonusNumber(userLottoNums, matchCount));
        }

        printResultStats(purchaseAmount);
    }

    private void printResultStats(int purchaseAmount) {
        messageUtil.printWinningStatsResult(THREE_COUNT.getNumber(), THREE_COUNT.getPrice(), lottoResult.getThreeCount());
        messageUtil.printWinningStatsResult(FOUR_COUNT.getNumber(), FOUR_COUNT.getPrice(), lottoResult.getFourCount());
        messageUtil.printWinningStatsResult(FIVE_COUNT.getNumber(), FIVE_COUNT.getPrice(), lottoResult.getFiveCount());
        messageUtil.printWinningStatsResult(FIVE_COUNT_WITH_BONUS.getNumber(), FIVE_COUNT_WITH_BONUS.getPrice(), lottoResult.getFiveWithBonusCount());
        messageUtil.printWinningStatsResult(SIX_COUNT.getNumber(), SIX_COUNT.getPrice(), lottoResult.getSixCount());

        long totalWinningAmount = getTotalWinningAmount();
        double earningRate = Double.parseDouble(computeEarningRate(purchaseAmount, totalWinningAmount));

        messageUtil.printEarningRate(earningRate);
    }

    private long getTotalWinningAmount() {
        return (long) lottoResult.getThreeCount() * THREE_COUNT.getPrice()
                + (long)lottoResult.getFourCount() * FOUR_COUNT.getPrice()
                + (long) lottoResult.getFiveCount() * FIVE_COUNT.getPrice()
                + (long) lottoResult.getFiveWithBonusCount() * FIVE_COUNT_WITH_BONUS.getPrice()
                + (long) lottoResult.getSixCount() * SIX_COUNT.getPrice();
    }

    private void addMatchCount(int matchCount) {
        if (matchCount == THREE_COUNT.getNumber()) {
            lottoResult.addThreeCount();
        }
        if (matchCount == FOUR_COUNT.getNumber()) {
            lottoResult.addFourCount();
        }
        if (matchCount == FIVE_COUNT.getNumber()) {
            lottoResult.addFiveCount();
        }
        if (matchCount == FIVE_COUNT_WITH_BONUS.getNumber()) {
            lottoResult.addFiveWithBonusCount();
        }
        if (matchCount == SIX_COUNT.getNumber()) {
            lottoResult.addSixCount();
        }
    }

    private int getMatchCount(List<Integer> userNums) {
        return Long.valueOf(winningNumInfo.getWinningNums()
                .stream()
                .filter(lottoNum -> userNums.stream()
                        .anyMatch(Predicate.isEqual(lottoNum)))
                .count()).intValue();
    }

    private int checkBonusNumber(List<Integer> userNums, int matchCount) {
        if (matchCount == FIVE_COUNT.getNumber() && userNums.contains(winningNumInfo.getBonusNum())) {
            return matchCount * 10;
        }

        return matchCount;
    }

    private String computeEarningRate(int purchaseAmount, long winningAmount) {
        if (winningAmount == 0) {
            return "0";
        }

        double earningRate = (double) winningAmount / (double) purchaseAmount * 100;
        return String.format("%.1f", earningRate);
    }
}
