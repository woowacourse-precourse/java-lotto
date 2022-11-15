package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.MoneyParser;
import lotto.view.Terminal;
import lotto.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoSystem {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;
    public static final int LOTTO_NUM_COUNT = 6;

    private final View view = new Terminal();

    public void run() {
        MoneyParser moneyParser = new MoneyParser();
        int lottoCount = moneyParser.parse(view.requestMoney()) / LOTTO_PRICE;
        view.printLottoCount(lottoCount);
        List<Lotto> boughtLottos = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            boughtLottos.add(new Lotto(numbers));
        }
    }
}
