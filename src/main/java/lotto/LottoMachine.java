package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {

    public LottoMachine() {
    }

    public List<Lotto> createLottoWithMoney(int money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 1; i <= money / 1000; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }


    private Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
