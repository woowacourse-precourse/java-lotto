package lotto.service;

import lotto.enums.Ranking;
import lotto.domain.Lotto;
import lotto.domain.LottoAnswer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningCheck {
    private static final int ZERO = 0;
    private static final int FIVE = 5;
    private static final double FIVE_POINT_FIVE = 5.5;
    private static final int ONE = 1;
    private static final double HUNDRED = 100.0;
    Map<Ranking, Integer> lottoResult;

    public Map<Ranking, Integer> getLottoResult() {
        return lottoResult;
    }

    public WinningCheck(List<Lotto> userLottos, LottoAnswer lottoAnswer) {
        lottoResult = new HashMap<>();
        initLottoResult();
        for(Lotto userLotto : userLottos) {
            lottoResultCount(haveNumberCount(userLotto.getNumbers(), lottoAnswer.getNumbers(), lottoAnswer.getBonusNumber()));
        }
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

    public double calculate(int money) {
        double resultMoney = ZERO;
        for (Ranking ranking : Ranking.values()) {
            resultMoney += lottoResult.get(ranking) * ranking.money();
        }
        return Math.round(resultMoney / money * HUNDRED * HUNDRED) / HUNDRED;
    }

}
