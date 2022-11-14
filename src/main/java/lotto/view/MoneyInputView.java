package lotto.view;

import lotto.Env;
import lotto.util.Lang;

public class MoneyInputView extends View {
    private String money;

    @Override
    public void show() {
        printLine(Lang.VIEW_ENTER_PURCHASE_AMOUNT);
        printLine(Lang.format(Lang.VIEW_ENTER_NUMBER_AND_KEEP_UNIT, Env.LOTTO_PRICE));

        this.money = readLine(Lang.VIEW_EXAMPLE_MONEY);
    }

    @Override
    public String getResponse() {
        return this.money;
    }
}
