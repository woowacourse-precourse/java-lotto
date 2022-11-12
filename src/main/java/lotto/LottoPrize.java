package lotto;

import lotto.util.MessageUtil;

import java.util.List;
import java.util.function.Predicate;

public class LottoPrize {

    private final MessageUtil messageUtil = new MessageUtil();

    private final LottoWinningNumber winningNumInfo;

    private static final Integer BONUS_AVAILABLE_NUM = 5;

    public LottoPrize(LottoWinningNumber lottoWinningNumber) {
        this.winningNumInfo = lottoWinningNumber;
    }
    public void getLottoStats(List<Lotto> userLottos) {
        messageUtil.printWinningStats();

        for(Lotto userLotto : userLottos) {
            List<Integer> userLottoNums = userLotto.getLottoNumbers();
            int matchCount = getMatchCount(userLottoNums);
            matchCount  = checkBonusNumber(userLottoNums, matchCount);
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
        if(matchCount == BONUS_AVAILABLE_NUM && userNums.contains(matchCount)) {
            return matchCount * 10;
        }
        return matchCount;
    }

    public String computeEarningRate(int purchaseAmount, int winningAmount) {
        double earningRate = (double) (purchaseAmount / winningAmount) * 100;
        return String.format("%.1f", earningRate);
    }

}
