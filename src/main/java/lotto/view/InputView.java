package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.InputMessage;
import lotto.utils.Validator;

public class InputView {
    private static final Validator validator = new Validator();
    public String inputUserMoney() {
        System.out.println(InputMessage.INPUT_MONEY);
        String input = Console.readLine();
        validator.isValidMoney(input);
        return input;
    }
}
