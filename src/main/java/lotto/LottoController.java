package lotto;

import lotto.global.Message;

public class LottoController {

    public Integer getUserLottoCount() {
        UserInput userInput = new UserInput();

        Message.GAME_INPUT.print();
        Integer userMoney = userInput.getUserInput();
        return userMoney / 1000;
    }

}
