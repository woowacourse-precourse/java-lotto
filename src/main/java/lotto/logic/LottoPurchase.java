package lotto.logic;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionValidation;
import lotto.message.Constant;
import lotto.message.InputForm;

public class LottoPurchase {

    public int puchaseLotto() {
        int amount = inputAmount();
        ExceptionValidation.validateException(amount);
        System.out.println(amount / Constant.PRICE.getConstant() + "개를 구매했습니다.");
        return amount;
    }

    private int inputAmount() {
        System.out.println(InputForm.INPUT_PRICE);
        String input = Console.readLine();
        return ExceptionValidation.isNumber(input);
    }
}


