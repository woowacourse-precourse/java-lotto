package lotto.service;

import lotto.Enum.Ranking;
import lotto.domain.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningCheck {
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
            lottoResult.put(ranking, 0);
        }
    }

    private double haveNumberCount(List<Integer> userLotto, List<Integer> answerNumbers, int bonusNumber) {
        double count = 0;
        for(int number : answerNumbers) {
            if(userLotto.contains(number)) {
                count++;
            }
        }
        if (count == 5 && bonusNumberCheck(bonusNumber, answerNumbers)) {
            count = 5.5;
        }
        return count;
    }

    private boolean bonusNumberCheck(int bonusNumber, List<Integer> answerNumbers) {
        return answerNumbers.contains(bonusNumber);
    }

    private void lottoResultCount(double count) {
        Ranking ranking = Ranking.valueOfNumber(count);
        lottoResult.computeIfPresent(ranking, (k, v) -> v + 1);
    }
}
