package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.config.Constants.LottoNumber.*;
import static lotto.config.Constants.LottoPrice.LOTTO_PRICE;

public class LottoPublisher {

    private List<Lotto> lottos;

    public LottoPublisher() {
        this.lottos = new ArrayList<>();
    }

    public void publish(int money) {

        validate(money);

        for (int i = 0; i < affordableLotto(money); i++) {
            lottos.add(new Lotto(getRandomLottoNumber()));
        }
    }

    private void validate(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    private int affordableLotto(int money) {
        return money / LOTTO_PRICE;
    }

    private List<Integer> getRandomLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START_INCLUSIVE, LOTTO_NUMBER_END_INCLUSIVE, LOTTO_SIZE);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
