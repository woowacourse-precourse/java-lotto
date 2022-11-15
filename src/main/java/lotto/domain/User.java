package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.MoneyAmountValidator;

public class User {
    public int inputOfAmount(){
        String userInput = Console.readLine();
        MoneyAmountValidator.validateInputType(userInput);
        int moneyAmount = Integer.parseInt(userInput);
        MoneyAmountValidator.validateMoneyAmount(moneyAmount);
        return moneyAmount;
    }
}
