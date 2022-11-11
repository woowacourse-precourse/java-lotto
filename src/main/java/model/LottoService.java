package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public List<Lotto> issueLotto(int money) {
        List<Lotto> lotteries = new ArrayList<>();

        for (int i = 0; i < getCount(money); i++) {
            lotteries.add(createLotto());
        }
        return lotteries;
    }

    private Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(
                LottoStatus.START.getValue(),
                LottoStatus.END.getValue(),
                LottoStatus.SIZE.getValue()));
    }

    private int getCount(int money) {
        return money / LottoStatus.PRICE.getValue();
    }
}
