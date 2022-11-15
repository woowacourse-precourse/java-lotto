package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Message;

public class UserInput {
    public static String getInputUserMoney(){
        String inputUserMoney = Console.readLine();
        validateInputUserMoney(inputUserMoney);

        return inputUserMoney;
    }

    private static void validateInputUserMoney(String inputUserMoney) {
        if (Validator.isEmpty(inputUserMoney)){
            Message.printInputErrorEmpty();
            throw new IllegalArgumentException();
        }

        if (!Validator.hasNotCharacter(inputUserMoney)){
            Message.printInputErrorHasCharacter();
            throw new IllegalArgumentException();
        }
    }
}
