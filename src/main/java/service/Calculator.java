package service;

import common.regulation.NumberRule;
import exception.InputException;

public class Calculator {

    public static int getQuantity(String input) {
        InputException.validateInputAmount(input);

        int total = Integer.parseInt(input);
        int oneLottoPrice = NumberRule.LOTTO_ONE_PRICE.getValue();

        return total / oneLottoPrice;
    }
}
