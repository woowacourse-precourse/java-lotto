package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.User;
import lotto.view.GameMessage;

public class GameController {
    private GameMessage gameMessage = new GameMessage();
    private User user;

    public void run() {
        inputPurchaseAmount();
    }

    public void inputPurchaseAmount() {
        gameMessage.printInputPurchaseAmount();
        user = new User(Console.readLine());
    }
}
