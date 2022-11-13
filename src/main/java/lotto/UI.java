package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UI {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_LOTTO_MESSAGE = "개를 구매했습니다.";

    private final LottoLogic lottoLogic;

    public UI() {
        lottoLogic = new LottoLogic(moneyInput());
        printNumberOfLotto();
    }

    private int moneyInput() {
        System.out.println(MONEY_INPUT_MESSAGE);
        String moneyInput = Console.readLine();
        Validation.validateMoneyInput(moneyInput);

        return Integer.parseInt(moneyInput);
    }

    private void printNumberOfLotto() {
        System.out.println(this.lottoLogic.getNumberOfLotto() + PURCHASE_LOTTO_MESSAGE);
    }
}