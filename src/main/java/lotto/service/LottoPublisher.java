package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.config.Constants.LottoNumber.*;
import static lotto.config.Constants.LottoPrice.LOTTO_PRICE;

public class LottoPublisher {

    public List<Lotto> publish(int money) {
        validate(money);
        return buyLotto(money);
    }

    private List<Lotto> buyLotto(int money) {
        List<Lotto> Lottery = new ArrayList<>();
        for (int i = 0; i < calculateAffordableLotto(money); i++) {
            Lottery.add(getLottoNumber());
        }
        return Lottery;
    }

    private void validate(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    private int calculateAffordableLotto(int money) {
        return money / LOTTO_PRICE;
    }

    private Lotto getLottoNumber() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START_INCLUSIVE, LOTTO_NUMBER_END_INCLUSIVE, LOTTO_SIZE));
    }
}
