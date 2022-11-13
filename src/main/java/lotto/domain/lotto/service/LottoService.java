package lotto.domain.lotto.service;

import lotto.domain.lotto.domain.Lotto;
import lotto.domain.view.InputView;
import lotto.domain.view.OutputView;
import lotto.global.util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    private static final String MATCH_MESSAGE = "일치하는 볼 개수 %d개, 보너스 볼 개수 %d개";

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
            for (int i : lotto.getNumbers()) {
                if (prizeLotto.getNumbers().contains(i)) {
                    ball++;
                }

                if (i == bonusNumber) {
                    bonus++;
                }
            }
            putValues(result, getKey(ball, bonus));
        }
        return OutputView.printResult(result);
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

    // 수익률 = 수익 / 로또 산 돈 * 100
    public Double getGrossEarnings(double benefit, double investmentAmount) {
        return benefit / investmentAmount * 100;
    }
}