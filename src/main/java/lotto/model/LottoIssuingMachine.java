package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.LottoConstant.*;

public class LottoIssuingMachine {

    private List<Lotto> lottos;

    public LottoIssuingMachine() {
        lottos = new ArrayList<>();
    }

    protected List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Lotto lotto : lottos) {
            builder.append(lotto)
                    .append("\n");
        }
        return builder.toString();
    }

    public int getNumberOfIssuedLottos() {
        return lottos.size();
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
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_MONEY_MIN);
        }
        if (purchaseMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_MONEY_UNIT);
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
