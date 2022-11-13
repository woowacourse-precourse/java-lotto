package lotto;

import lotto.util.MessageUtil;

import java.util.List;
import java.util.function.Predicate;

import static lotto.constant.LottoResult.*;

public class LottoPrize {

    private final MessageUtil messageUtil = new MessageUtil();

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
        messageUtil.printWinningStatsResult(THREE_COUNT.getNumber(), THREE_COUNT.getPrice(), THREE_COUNT.getMatchCount());
        messageUtil.printWinningStatsResult(FOUR_COUNT.getNumber(), FOUR_COUNT.getPrice(), FOUR_COUNT.getMatchCount());
        messageUtil.printWinningStatsResult(FIVE_COUNT.getNumber(), FIVE_COUNT.getPrice(), FIVE_COUNT.getMatchCount());
        messageUtil.printWinningStatsResult(FIVE_COUNT_WITH_BONUS.getNumber(), FIVE_COUNT_WITH_BONUS.getPrice(), FIVE_COUNT_WITH_BONUS.getMatchCount());
        messageUtil.printWinningStatsResult(SIX_COUNT.getNumber(), SIX_COUNT.getPrice(), SIX_COUNT.getMatchCount());

        int totalWinningAmount = getTotalWinningAmount();
        Double earningRate = Double.valueOf(computeEarningRate(purchaseAmount, totalWinningAmount));
        messageUtil.printEarningRate(earningRate);
    }

    private int getTotalWinningAmount() {
        return THREE_COUNT.getMatchCount() * THREE_COUNT.getPrice()
                + FOUR_COUNT.getMatchCount() * FOUR_COUNT.getPrice()
                + FIVE_COUNT.getMatchCount() * FIVE_COUNT.getPrice()
                + FIVE_COUNT_WITH_BONUS.getMatchCount() * FIVE_COUNT_WITH_BONUS.getPrice()
                + SIX_COUNT.getMatchCount() * SIX_COUNT.getPrice();
    }

    private void addMatchCount(int matchCount) {
        if (matchCount == THREE_COUNT.getNumber()) {
            THREE_COUNT.addMatchCount();
        }
        if (matchCount == FOUR_COUNT.getNumber()) {
            FOUR_COUNT.addMatchCount();
        }
        if (matchCount == FIVE_COUNT.getNumber()) {
            FIVE_COUNT.addMatchCount();
        }
        if (matchCount == FIVE_COUNT_WITH_BONUS.getNumber()) {
            FIVE_COUNT_WITH_BONUS.addMatchCount();
        }
        if (matchCount == SIX_COUNT.getNumber()) {
            SIX_COUNT.addMatchCount();
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
        if(matchCount == FIVE_COUNT.getNumber() && userNums.contains(matchCount)) {
            return matchCount * 10;
        }

        return matchCount;
    }

    public String computeEarningRate(int purchaseAmount, int winningAmount) {
        double earningRate = (double) (purchaseAmount / winningAmount) * 100;

        return String.format("%.1f", earningRate);
    }

}
