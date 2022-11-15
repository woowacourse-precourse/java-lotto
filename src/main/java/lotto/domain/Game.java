package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.ui.Input;
import lotto.utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public Game() {
        createLottoWithCount(getLottoCount(Input.getPurchaseAmount()));
    }

    public Integer getLottoCount(int amount) {
        return amount / Constant.PURCHASE_AMOUNT_UNIT;
    }

    public Lotto createLotto() {
        return new Lotto(getRandomLottoNumber());
    }

    public List<Lotto> createLottoWithCount(int count) {
        List<Lotto> lotto = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lotto.add(createLotto());
        }

        return lotto;
    }

    public List<Integer> getRandomLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(Constant.MIN_LOTTO_NUMBER, Constant.MAX_LOTTO_NUMBER, Constant.LOTTO_NUMBER_COUNT);
    }
}
