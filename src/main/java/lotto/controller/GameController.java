package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.GameConstants;
import lotto.model.User;
import lotto.view.GameMessage;

public class GameController {
    private GameMessage gameMessage = new GameMessage();
    private User user;

    public void run() {
        gameMessage.print(GameConstants.INPUT_PURCHASE_AMOUNT);
        user = new User(Console.readLine());
    }
}
