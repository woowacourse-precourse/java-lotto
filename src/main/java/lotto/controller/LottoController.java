package lotto.controller;

import lotto.model.User;
import lotto.view.UserInterface;

public class LottoController {
    UserInterface userInterface = new UserInterface();

    public void gameStart() throws IllegalArgumentException {
        User user = new User("구입금액");
        user.validateUserMoney(userInterface.getUserInput("구입금액"));


    }
}
