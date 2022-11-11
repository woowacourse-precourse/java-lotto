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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(lottos.size())
                .append("개를 구매했습니다.\n");
        for (Lotto lotto : lottos) {
            builder.append(lotto).append("\n");
        }
        return builder.toString();
    }

    public void issue(int purchaseMoney) {
        validate(purchaseMoney);
        int quantity = purchaseMoney / LOTTO_PRICE;
        while (lottos.size() != quantity) {
            Lotto lotto = issueLotto();
            lottos.add(lotto);
        }
    }

    private void validate(int purchaseMoney) {
        if (purchaseMoney < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 로또 최소 구입 금액은 1,000원입니다.");
        }
        if (purchaseMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위이어야 합니다.");
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
