package lotto.controller;

import lotto.model.MoneyParser;
import lotto.view.Terminal;
import lotto.view.View;

public class LottoSystem {
    public static final int LOTTO_PRICE = 1000;

    private final View view = new Terminal();
    private final MoneyParser moneyParser = new MoneyParser();

    public void run() {
        int money = moneyParser.parse(view.requestMoney());
    }
}
