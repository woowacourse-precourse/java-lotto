package lotto.controller;

import lotto.view.Message;

public class GameController {
    private final Message message = new Message();

    public void buyLotto() {
        message.inputPrice();
        }
    }
}
