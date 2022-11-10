package lotto;

import lotto.console.Console;
import lotto.console.MoneyInput;

public class LottoStore {
    private static final String PLEASE_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private final Console moneyInput = new MoneyInput();
    private int lottoAmount;

    public void payLotto() {
        System.out.println(PLEASE_INPUT_MONEY);
        calculateLottoAmount(moneyInput.getUserInput());
        System.out.println();
    }

    private void calculateLottoAmount(String input) {
        lottoAmount = Integer.parseInt(input) / 1000;
    }

}
