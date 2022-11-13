package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoGameController;
import lotto.exception.InputException;
import lotto.message.GameMessage;

public class LottoGame {

    private final LottoGameController lottoGameController;

    private String userInput;

    public LottoGame() {
        this.lottoGameController = new LottoGameController();
    }

    public void start() {
        System.out.println(GameMessage.PURCHASE_AMOUNT.getMessage());
        userInput = Console.readLine();
        lottoGameController.inputMoney(userInput);
    }
}
