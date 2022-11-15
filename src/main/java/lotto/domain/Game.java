package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.Constant;

import java.util.List;

public class Game {
    public Game() {
    }

    public Integer getLottoCount(int amount) {
        return amount / Constant.PURCHASE_AMOUNT_UNIT;
    }

    private List<Integer> getRandomLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(Constant.MIN_LOTTO_NUMBER, Constant.MAX_LOTTO_NUMBER, Constant.LOTTO_NUMBER_COUNT);
    }
}
