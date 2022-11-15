package lotto.View;

import static lotto.View.OutputView.printBlankLine;

import lotto.Utils.Util;

public class InputView {

    private static final String PRINT_ASK_AMOUT = "구입금액을 입력해 주세요.";
    private static final String PRINT_ASK_WINNING_LOTTO = "당첨 번호를 입력해 주세요.";
    private static final String PRINT_ASK_BONUS_LOTTO = "보너스 번호를 입력해 주세요.";

    public static String purchaseAmountInput() {
        System.out.println(PRINT_ASK_AMOUT);
        return Util.getInput();
    }

    public static String WinningLottoInput() {
        printBlankLine();
        System.out.println(PRINT_ASK_WINNING_LOTTO);
        return Util.getInput();
    }

    public static String BonusLottoInput() {
        printBlankLine();
        System.out.println(PRINT_ASK_BONUS_LOTTO);
        return Util.getInput();
    }

}
