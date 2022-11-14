package lotto.view;

import lotto.Env;
import lotto.util.Lang;

public class LottoNumberInputView extends View {
    private String response;

    @Override
    public void show() {
        printLine(Lang.VIEW_ENTER_WIN_NUMBER);
        printLine(Lang.format(
                Lang.VIEW_ENTER_NON_DUPLICATE_NUMBERS,
                Env.LOTTO_FIRST_NUMBER,
                Env.LOTTO_LAST_NUMBER
        ));

        this.response = readLine(Lang.VIEW_EXAMPLE_NUMBERS);
    }

    @Override
    public String getResponse() {
        return response;
    }
}
