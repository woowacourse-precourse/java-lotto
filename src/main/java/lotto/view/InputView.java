package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputException;

public class InputView {
    private final static String REQUEST_PURCHASE_PRICE = "구입금액을 입력해 주세요.";

    public int readPurchasePrice() {
        System.out.println(REQUEST_PURCHASE_PRICE);
        String purchasePrice = Console.readLine();
        InputException.validateIsNumber(purchasePrice);
        printNewLine();

        return Integer.parseInt(purchasePrice);
    }

    private void printNewLine() {
        System.out.println();
    }
}
