package lotto.view;

import lotto.model.Lottos;
import lotto.model.Result;

public class LottoView {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final LottoView INSTANCE = new LottoView();

    private LottoView() {
    }

    public static LottoView getInstance() {
        return INSTANCE;
    }

    public void printMoneyInputMessage() {
        System.out.println(MONEY_INPUT_MESSAGE);
    }

    public void printLottos(Lottos lottos) {
        System.out.println("\n" + lottos);
    }

    public void printWinningNumberInputMessage() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
    }

    public void printBonusNumberInputMessage() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public void printResult(Result result) {
        System.out.println("\n" + result);
    }
}
