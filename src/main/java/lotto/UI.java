package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UI {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";


    private final LottoLogic lottoLogic;

    public UI() {
        lottoLogic = new LottoLogic(moneyInput());
    }

    private int moneyInput() {
        System.out.println(MONEY_INPUT_MESSAGE);
        String moneyInput = Console.readLine();

        return Integer.parseInt(moneyInput);
    }
}
