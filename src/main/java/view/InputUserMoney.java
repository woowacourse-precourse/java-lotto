package view;

import static util.ValidateUserMoney.validateMoney;

import camp.nextstep.edu.missionutils.Console;
import constant.ExceptionNumber;

public class InputUserMoney {

    public static int inputMoney(){
        String input_money = Console.readLine();

        if(!validateMoney(input_money)){
            return ExceptionNumber.EXCEPTION_CODE.getCode();
        }
        return Integer.parseInt(input_money);
    }


}
