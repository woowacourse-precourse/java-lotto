package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoData {
    int lottoAmount;
    double prizeMoneySum;
    Map<Integer, Integer> prize;
    List<Lotto> allLotto;
    LottoCalculate lottoCalculate = new LottoCalculate();

    LottoData(double money) {
        this.lottoAmount = (int) (money / 1000);
        allLotto = new ArrayList<>(lottoAmount);
    }

    void makeLotto() {
        List<Integer> lottoNumbers;
        while (allLotto.size() != lottoAmount) {
            lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers.sort(Comparator.naturalOrder());
            Lotto lotto = new Lotto(lottoNumbers);
            allLotto.add(lotto);
        }
    }

    void putDataToLotto(List<Integer> winNumbers, int bonusNumber) {
        for (Lotto lotto : allLotto) {
            lottoCalculate.totalCalculate(lotto, winNumbers, bonusNumber);
        }
    }

    void countPrize() {
        prize = new HashMap<>();
        for (Lotto lotto : allLotto) {
            prize.merge(lotto.prize, 1, Integer::sum);
        }
    }

    void sumPrizeMoney() {
        prizeMoneySum = 0d;
        for (Lotto lotto : allLotto) {
            prizeMoneySum += lotto.getPrizeMoney();
        }
    }
}
