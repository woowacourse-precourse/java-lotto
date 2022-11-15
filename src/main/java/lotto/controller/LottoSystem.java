package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.MoneyParser;
import lotto.view.Terminal;
import lotto.view.View;
import java.util.List;

public class LottoSystem {
    public static final int LOTTO_PRICE = 1000;

    private final View view = new Terminal();

    public void run() {
        MoneyParser moneyParser = new MoneyParser();
        int lottoCount = moneyParser.parse(view.requestMoney()) / LOTTO_PRICE;
        view.printLottoCount(lottoCount);
        for(int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        }

    }
}
