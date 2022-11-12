package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class AutoLottoSeller {

    private Lotto selectRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return new Lotto(randomNumbers);
    }

    private int buyaFewLotto(int money) {
        return money / 1000;
    }

    public List<Lotto> buyLotto(int money) {
        int cnt = buyaFewLotto(money);
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            lottoNumbers.add(selectRandomNumbers());
        }
        return lottoNumbers;
    }


}
