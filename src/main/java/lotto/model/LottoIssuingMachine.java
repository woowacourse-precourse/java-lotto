package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoIssuingMachine {

    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottos;

    public LottoIssuingMachine() {
        lottos = new ArrayList<>();
    }

    public void issue(int purchaseMoney) {
        int quantity = purchaseMoney / LOTTO_PRICE;
        while (lottos.size() != quantity) {
            Lotto lotto = issueLotto();
            lottos.add(lotto);
        }
    }

    private Lotto issueLotto() {
        while (true) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto issuedLotto = new Lotto(numbers);
            if (!lottos.contains(issuedLotto)) return issuedLotto;
        }
    }
}
