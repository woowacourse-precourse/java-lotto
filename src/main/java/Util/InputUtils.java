package Util;

import camp.nextstep.edu.missionutils.Console;
import domain.Validate;

import static Util.UiMessage.inputBuyMessage;


public class InputUtils {

    private final static Validate validate = new Validate();

    public static int StringToMoney() {
        inputBuyMessage();
        String money = Console.readLine();
        validate.validateMoney(money);
        return Integer.parseInt(money);
    }
}
