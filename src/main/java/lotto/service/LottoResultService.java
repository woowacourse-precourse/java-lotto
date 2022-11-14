package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoResultConstant;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public class LottoResultService {

    public static Map<LottoResultConstant, Integer> getResult(List<Lotto> userLotto, WinningLotto winningLotto) {
        Map<LottoResultConstant, Integer> winningStatistics = initWinningStatistics();
        for (Lotto lotto : userLotto) {
            int[] correctCountAndBonusCount = lotto.compareToWinningLotto(winningLotto);
            LottoResultConstant lottoResultConstantFromCorrectCountAndBonusCount = getLottoResultConstantFromCorrectCountAndBonusCount(
                    correctCountAndBonusCount);
            winningStatistics.put(lottoResultConstantFromCorrectCountAndBonusCount,
                    winningStatistics.get(lottoResultConstantFromCorrectCountAndBonusCount) + 1);
        }
        return winningStatistics;
    }

    private static Map<LottoResultConstant, Integer> initWinningStatistics() {
        Map<LottoResultConstant, Integer> winningStatistics = new HashMap<>();
        winningStatistics.put(LottoResultConstant.EMPTY, 0);
        winningStatistics.put(LottoResultConstant.CORRECT_THREE, 0);
        winningStatistics.put(LottoResultConstant.CORRECT_FOUR, 0);
        winningStatistics.put(LottoResultConstant.CORRECT_FIVE, 0);
        winningStatistics.put(LottoResultConstant.CORRECT_FIVE_CORRECT_BONUS, 0);
        winningStatistics.put(LottoResultConstant.CORRECT_SIX, 0);
        return winningStatistics;
    }

    private static LottoResultConstant getLottoResultConstantFromCorrectCountAndBonusCount(int[] correctCountAndBonusCount) {
        if (correctCountAndBonusCount[0] == 3) {
            return LottoResultConstant.CORRECT_THREE;
        } else if (correctCountAndBonusCount[0] == 4) {
            return LottoResultConstant.CORRECT_FOUR;
        } else if (correctCountAndBonusCount[0] == 5) {
            if (correctCountAndBonusCount[1] == 1) {
                return LottoResultConstant.CORRECT_FIVE_CORRECT_BONUS;
            }
            return LottoResultConstant.CORRECT_FIVE;
        } else if (correctCountAndBonusCount[0] == 6) {
            return LottoResultConstant.CORRECT_SIX;
        }
        return LottoResultConstant.EMPTY;
    }

}
