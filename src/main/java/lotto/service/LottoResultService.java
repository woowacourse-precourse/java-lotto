package lotto.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.constant.IntConstant;
import lotto.constant.LottoResultConstant;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public class LottoResultService {
    public void getResult(List<Lotto> userLotto, List<Integer> winningLottoInput, int bonusLottoInput) {
        WinningLotto winningLotto = createWinningLotto(winningLottoInput, bonusLottoInput);
        Map<LottoResultConstant, Integer> winningStatistics = initWinningStatistics();
        for (Lotto lotto : userLotto) {
            int[] correctCountAndBonusCount = lotto.compareToWinningLotto(winningLotto);
            LottoResultConstant lottoResultConstantFromCorrectCountAndBonusCount = getLottoResultConstantFromCorrectCountAndBonusCount(
                    correctCountAndBonusCount);
            winningStatistics.put(lottoResultConstantFromCorrectCountAndBonusCount,
                    winningStatistics.get(lottoResultConstantFromCorrectCountAndBonusCount) + 1);
        }
    }

    private WinningLotto createWinningLotto(List<Integer> winningLottoResult, int bonusLottoResult) {
        return new WinningLotto(winningLottoResult, bonusLottoResult);
    }

    private Map<LottoResultConstant, Integer> initWinningStatistics() {
        Map<LottoResultConstant, Integer> winningStatistics = new HashMap<>();
        winningStatistics.put(LottoResultConstant.EMPTY, 0);
        winningStatistics.put(LottoResultConstant.CORRECT_THREE, 0);
        winningStatistics.put(LottoResultConstant.CORRECT_FOUR, 0);
        winningStatistics.put(LottoResultConstant.CORRECT_FIVE, 0);
        winningStatistics.put(LottoResultConstant.CORRECT_FIVE_CORRECT_BONUS, 0);
        winningStatistics.put(LottoResultConstant.CORRECT_SIX, 0);
        return winningStatistics;
    }

    private LottoResultConstant getLottoResultConstantFromCorrectCountAndBonusCount(int[] correctCountAndBonusCount) {
        if (correctCountAndBonusCount[0] == 3) {
            return LottoResultConstant.CORRECT_THREE;
        } else if (correctCountAndBonusCount[0] == 4) {
            return LottoResultConstant.CORRECT_FOUR;
        } else if (correctCountAndBonusCount[0] == 5) {
            if (correctCountAndBonusCount[1] == 1) {
                return LottoResultConstant.CORRECT_FIVE_CORRECT_BONUS;
            }
            return LottoResultConstant.CORRECT_FOUR;
        } else if (correctCountAndBonusCount[0] == 6) {
            return LottoResultConstant.CORRECT_SIX;
        }
        return LottoResultConstant.EMPTY;
    }





}
