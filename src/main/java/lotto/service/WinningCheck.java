package lotto.service;

import lotto.Enum.Ranking;
import lotto.domain.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningCheck {
    private static final int ZERO = 0;
    private static final int FIVE = 5;
    private static final double FIVE_POINT_FIVE = 5.5;
    private static final int ONE = 1;
    Map<Ranking, Integer> lottoResult = new HashMap<>();

    public Map<Ranking, Integer> winningCheck(List<Lotto> userLottos, List<Integer> answerNumbers, int bonusNumber) {
        initLottoResult();
        for(Lotto userLotto : userLottos) {
            lottoResultCount(haveNumberCount(userLotto.getNumbers(), answerNumbers, bonusNumber));
        }
        return lottoResult;
    }

    private void initLottoResult() {
        for (Ranking ranking : Ranking.values()) {
            lottoResult.put(ranking, ZERO);
        }
    }

    private double haveNumberCount(List<Integer> userLotto, List<Integer> answerNumbers, int bonusNumber) {
        double count = ZERO;
        for(int number : answerNumbers) {
            if(userLotto.contains(number)) {
                count++;
            }
        }
        if (count == FIVE && bonusNumberCheck(bonusNumber, answerNumbers)) {
            count = FIVE_POINT_FIVE;
        }
        return count;
    }

    private boolean bonusNumberCheck(int bonusNumber, List<Integer> answerNumbers) {
        return answerNumbers.contains(bonusNumber);
    }

    private void lottoResultCount(double count) {
        Ranking ranking = Ranking.valueOfNumber(count);
        lottoResult.computeIfPresent(ranking, (k, v) -> v + ONE);
    }

}
