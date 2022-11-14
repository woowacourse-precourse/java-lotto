package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.enums.GameMessage;

public class InputView {
    public static String buyLotto() {
        System.out.println(GameMessage.PRICE_MESSAGE.getMessage());
        return Console.readLine();
    }
    


}
