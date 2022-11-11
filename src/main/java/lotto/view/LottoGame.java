package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputException;
import lotto.message.MessageList;

public class LottoGame {

    private String userInput;

    public void start() {
        System.out.println(MessageList.PURCHASE_AMOUNT.getMessage());
        userInput = Console.readLine();
        InputException.validPurchaseAmount(userInput);
    }
}
