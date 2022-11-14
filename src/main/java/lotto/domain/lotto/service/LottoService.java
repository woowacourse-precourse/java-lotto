package lotto.domain.lotto.service;

import lotto.domain.lotto.domain.Lotto;
import lotto.domain.view.InputView;
import lotto.domain.view.OutputView;
import lotto.global.util.Util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.global.constant.ServiceConstants.*;

public class LottoService {

    public int lottoCount(int inputMoney) {
        return inputMoney / 1000;
    }

    public Lotto randomLottoNumbers() {
        return new Lotto(Util.orderByDescForList(Util.getRandomNumbers()));
    }

    public Lotto prizeLotto() {
        return new Lotto(Util.inputNumbersInList());
    }

    public int bonusNumber(Lotto prizeLotto) {
        return InputView.getInputBonusNumber(prizeLotto);
    }

    public Double compareNumbers(List<Lotto> lottos, Lotto prizeLotto, int bonusNumber) {
        Map<String, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos) {
            int ball = 0;
            int bonus = 0;
            Map<String, Integer> ballAndBonus = plusBallOrBonus(lotto, prizeLotto, bonusNumber);
            ball = ballAndBonus.get(BALL);
            bonus = ballAndBonus.get(BONUS);
            putValues(result, getKey(ball, bonus));
        }
        return OutputView.printResult(result);
    }

    private Map<String, Integer> plusBallOrBonus(Lotto lotto, Lotto prizeLotto, int bonusNumber) {
        int ball = 0;
        int bonus = 0;
        Map<String, Integer> ballAndBonus = new HashMap<>();
        for (int i : lotto.getNumbers()) {
            ball = compareBall(prizeLotto, i, ball);
            bonus = compareBonus(bonusNumber, i, bonus);
        }
        ballAndBonus.put(BALL, ball);
        ballAndBonus.put(BONUS, bonus);
        return ballAndBonus;
    }

    private int compareBall(Lotto prizeLotto, int i, int ball) {
        if (prizeLotto.getNumbers().contains(i)) {
            ball++;
        }
        return ball;
    }

    private int compareBonus(int bonusNumber, int i, int bonus) {
        if (i == bonusNumber) {
            bonus++;
        }
        return bonus;
    }

    private String getKey(int ball, int bonus) {
        return String.format(MATCH_MESSAGE, ball, bonus);
    }

    private void putValues(Map<String, Integer> result, String key) {
        if (result.get(key) != null) {
            result.put(key, result.get(key) + 1);
        }
        result.putIfAbsent(key, 1);
    }

    public Double getGrossEarnings(double benefit, double investmentAmount) {
        return benefit / investmentAmount * 100;
    }
}