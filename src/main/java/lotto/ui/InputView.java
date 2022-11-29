package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    Message message = new Message();

    public String getPrice() {
        message.INPUT_PRICE_MESSAGE();
        return Console.readLine();
    }

    public String getNumbers() {
        message.INPUT_NUMBER_MESSAGE();
        return Console.readLine();
    }

    public String getBonus() {
        message.INPUT_BONUS_NUMBER_MESSAGE();
        return Console.readLine();
    }



}
