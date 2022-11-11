package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoData {
    int lottoAmount;
    List<Lotto> allLotto;
    LottoCalculate lottoCalculate = new LottoCalculate();

    LottoData(int money) {
        this.lottoAmount = money / 1000;
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
}
