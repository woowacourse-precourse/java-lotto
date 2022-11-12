package lotto.controller;

import lotto.GameConstants;
import lotto.view.GameMessage;

public class GameController {
    private GameMessage message = new GameMessage();

    public void run() {
        message.print(GameConstants.INPUT_PURCHASE_AMOUNT);
    }
}
