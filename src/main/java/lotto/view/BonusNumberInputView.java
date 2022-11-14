package lotto.view;

import lotto.Env;
import lotto.util.Lang;

public class BonusNumberInputView extends View {
    private String response;

    @Override
    public void show() {
        printLine(Lang.VIEW_ENTER_BONUS_NUMBER);
        printLine(Lang.format(
                Lang.VIEW_ENTER_RANGE_ONCE,
                Env.LOTTO_FIRST_NUMBER,
                Env.LOTTO_LAST_NUMBER
        ));

        this.response = readLine(Lang.VIEW_EXAMPLE_NUMBER);
    }

    @Override
    public String getResponse() {
        return response;
    }
}
