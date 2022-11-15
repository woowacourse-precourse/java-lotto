package lotto.domain.lottoDevice;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.lottoData.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private final int LOTTO_PRICE = 1000;

    public List<Lotto> createLottoWithMoney(int money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 1; i <= money / LOTTO_PRICE; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }


    private Lotto createLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
