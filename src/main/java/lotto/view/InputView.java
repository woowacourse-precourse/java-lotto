package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.LottoMessage;

public class InputView {
    public static String purchasePrice() {
        System.out.println(LottoMessage.PURCHASE_PRICE.getMessage());
        return getUserInput();
    }

    public static String inputWinningLotto() {
        System.out.println(LottoMessage.WINNING_LOTTO.getMessage());
        return getUserInput();
    }

    private static String getUserInput() {
        return Console.readLine();
    }
}
