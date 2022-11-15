package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.dto.ScoreInfo;
import lotto.vo.*;

public class LottoServiceImpl implements LottoService {
    @Override
    public List<Lotto> createLottos(LottoBuyingInfo lottoBuyingInfo) {
        List<Lotto> result = new ArrayList<>();
        for (int count = 0; count < lottoBuyingInfo.getAmount(); count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoInfo.MIN_LOTTO_NUMBER, LottoInfo.MAX_LOTTO_NUMBER, LottoInfo.LOTTO_SIZE);
            result.add(new Lotto(numbers));
        }

        return result;
    }

    @Override
    public ScoreInfo makeScoreInfoBy(List<Lotto> lottos, WinningInfo winningInfo) {
        ScoreInfo scoreInfo = new ScoreInfo();
        for (Lotto lotto : lottos) {
            calculateRank(lotto, winningInfo, scoreInfo);
        }
        return scoreInfo;
    }

    @Override
    public Profit calculateProfitBy(LottoBuyingInfo lottoBuyingInfo, ScoreInfo scoreInfo) {
        return new Profit(countSumOfPrice(scoreInfo) / lottoBuyingInfo.getMoney())
                .convertToPercentage()
                .roundToFirstDigit();
    }

    private double countSumOfPrice(ScoreInfo scoreInfo) {
        return Arrays.stream(Score.values())
                .mapToDouble(score -> score.getPrice() * scoreInfo.get(score))
                .sum();
    }


    private void calculateRank(Lotto lotto, WinningInfo winningInfo, ScoreInfo scoreInfo) {
        int matchCount = getMatchCount(lotto, winningInfo);
        boolean bonusMatching = isBonusMatching(lotto, winningInfo);

        for (Score score : Score.values()) {
            if (score.isMatchingToScoreCondition(matchCount, bonusMatching)) {
                scoreInfo.addScore(score);
                return;
            }
        }
    }

    private static int getMatchCount(Lotto lotto, WinningInfo winningInfo) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(number -> winningInfo.isWinningNumbersContaining(number))
                .count();
    }

    private boolean isBonusMatching(Lotto lotto, WinningInfo winningInfo) {
        return lotto.contains(winningInfo.getBonus());
    }
}
