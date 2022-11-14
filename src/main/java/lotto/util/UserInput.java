package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Message;

public class UserInput {

    public static int getLottoMoney(){
        String inputLottoMoney = getInputLottoMoney();
        int lottoMoney = Converter.StringToInteger(inputLottoMoney);
        validateLottoMoney(lottoMoney);

        return lottoMoney;
    }

    private static void validateLottoMoney(int lottoMoney) {

        if(!Validator.isLottoMoney(lottoMoney)){
            Message.printInputErrorUserLottoMoney();
            throw new IllegalArgumentException();
        }
    }

    private static String getInputLottoMoney(){

        String inputLottoMoney = Console.readLine();
        validateInputLottoMoney(inputLottoMoney);

        return inputLottoMoney;
    }

    private static void validateInputLottoMoney(String inputLottoMoney) {

        if (!Validator.hasNotCharacter(inputLottoMoney)){
            Message.printInputErrorHasCharacter();
            throw new IllegalArgumentException();
        }

        if (Validator.isEmpty(inputLottoMoney)){
            Message.printInputErrorEmpty();
            throw new IllegalArgumentException();
        }
    }
}
