package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Message;

public class UserInput {
    public static String getInputLottoMoney(){
        String inputLottoMoney = Console.readLine();
        validateInputLottoMoney(inputLottoMoney);

        return inputLottoMoney;
    }

    private static void validateInputLottoMoney(String inputLottoMoney) {
        if (Validator.isEmpty(inputLottoMoney)){
            Message.printInputErrorEmpty();
            throw new IllegalArgumentException();
        }

        if (!Validator.hasNotCharacter(inputLottoMoney)){
            Message.printInputErrorHasCharacter();
            throw new IllegalArgumentException();
        }
    }
}
