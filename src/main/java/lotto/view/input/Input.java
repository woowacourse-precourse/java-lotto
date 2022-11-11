package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.GuideMessage;

public class Input {

    public String scanMoneyInput() {
        System.out.println(GuideMessage.MONEY_INPUT_MESSAGE.getGuideMessage());
        String money = Console.readLine();
        System.out.println();
        return money;
    }
}
