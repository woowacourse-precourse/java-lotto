package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.lotto.Lotto.*;

public class LottoSeller {

    static final int PRICE = 1000;

    private Lotto createRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER,
                NUMBER_COUNT);
        return new Lotto(randomNumbers);
    }

    public List<Lotto> buyLottos(int money) {
        int lottoCount = money / PRICE;
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(createRandomLotto());
        }

        return lottoList;
    }
}
