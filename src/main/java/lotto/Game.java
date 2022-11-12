package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.utils.Constant;

public class Game {

    public int payDividedByUnit(int money) {
        return money / Constant.MONEY_UNIT;
    }

    public List<Lotto> makeLottoNumbers(int n) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lottos.add(new Lotto(getRandomLottoNumbers()));
        }
        return lottos;
    }

    private List<Integer> getRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(Constant.NUMBER_START, Constant.NUMBER_END, Constant.LOTTO_SIZE);
    }
}
