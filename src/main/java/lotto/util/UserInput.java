package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Message;

public class UserInput {

    public static int getMoney(){
        String inputMoney = getInputMoney();
        int money = Converter.StringToInteger(inputMoney);
        validateMoney(money);

        return money;
    }

    private static void validateMoney(int money) {

        if(!Validator.isLottoMoney(money)){
            Message.printInputErrorUserMoney();
            throw new IllegalArgumentException();
        }
    }

    private static String getInputMoney(){

        String inputMoney = Console.readLine();
        validateInputMoney(inputMoney);

        return inputMoney;
    }

    private static void validateInputMoney(String inputMoney) {

        if (!Validator.hasNotCharacter(inputMoney)){
            Message.printInputErrorHasCharacter();
            throw new IllegalArgumentException();
        }

        if (Validator.isEmpty(inputMoney)){
            Message.printInputErrorEmpty();
            throw new IllegalArgumentException();
        }
    }
}
