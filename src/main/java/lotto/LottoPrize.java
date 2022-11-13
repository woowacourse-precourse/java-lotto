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

    public void getLottoStats(List<Lotto> userLottos) {
        messageUtil.printWinningStats();

        for(Lotto userLotto : userLottos) {
            List<Integer> userLottoNums = userLotto.getLottoNumbers();
            int matchCount = getMatchCount(userLottoNums);
            addMatchCount(checkBonusNumber(userLottoNums, matchCount));
        }

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
