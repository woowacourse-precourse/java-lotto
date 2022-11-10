package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.LottoMessage;

public class InputView {
    public String inputPurchasePrice() {
        System.out.println(LottoMessage.PURCHASE_PRICE.getMessage());
        return getUserInput();
    }

    private String getUserInput() {
        return Console.readLine();
    }
}
