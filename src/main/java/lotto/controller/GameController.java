package lotto.controller;

import lotto.model.User;
import lotto.view.Message;

public class GameController {
    private final Message message = new Message();
    private final User user = new User();

    public void buyLotto() {
        message.inputPrice();
        user.inputPrice();
    }
}
