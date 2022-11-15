package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.config.Constants.LottoNumber.*;
import static lotto.config.Constants.LottoPrice.LOTTO_PRICE;
import static lotto.exception.LottoException.MONEY_ERROR;

public class LottoPublishService {

    public List<Lotto> publish(Long money) {
        validate(money);
        return buyLotto(money);
    }

    private List<Lotto> buyLotto(Long money) {
        List<Lotto> Lottery = new ArrayList<>();
        for (int i = 0; i < calculateAffordableLotto(money); i++) {
            Lottery.add(getLottoNumber());
        }
        return Lottery;
    }

    private void validate(Long money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MONEY_ERROR.getErrorMessage());
        }
    }

    private Long calculateAffordableLotto(Long money) {
        return money / LOTTO_PRICE;
    }

    private Lotto getLottoNumber() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START_INCLUSIVE, LOTTO_NUMBER_END_INCLUSIVE, LOTTO_SIZE));
    }
}
