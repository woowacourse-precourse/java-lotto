package lotto.controller;

import lotto.model.User;
import lotto.view.UserInterface;

public class LottoController {

    private static final String PURCHASE_AMOUNT = "구입금액";

    private String userInputMoney ;

    UserInterface userInterface = new UserInterface();

    public void gameStart() throws IllegalArgumentException {
        userInputMoney = userInterface.getUserInput(PURCHASE_AMOUNT);
        User userMoney = new User(PURCHASE_AMOUNT);
        userMoney.validateUserMoney(userInputMoney);




    }
}
