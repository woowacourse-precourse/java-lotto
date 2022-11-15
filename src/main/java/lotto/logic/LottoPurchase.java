package lotto.logic;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionValidation;
import lotto.data.Constant;
import lotto.data.InputForm;
import lotto.data.OutputForm;

public class LottoPurchase {

    public int puchaseLotto() {
        int amount = inputAmount();
        ExceptionValidation.validateException(amount);
        System.out.println(amount / Constant.PRICE.getConstant() + OutputForm.OUTPUT_COUNT.getMessage());
        return amount;
    }

    private int inputAmount() {
        System.out.println(InputForm.INPUT_PRICE.getMessage());
        String input = Console.readLine();
        return ExceptionValidation.isNumber(input);
    }
}


