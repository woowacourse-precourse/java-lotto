package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.MoneyAmountValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    public int inputOfAmount(){
        String userInput = Console.readLine();
        MoneyAmountValidator.validateInputType(userInput);
        int moneyAmount = Integer.parseInt(userInput);
        MoneyAmountValidator.validateMoneyAmount(moneyAmount);
        return moneyAmount;
    }

    public List<Integer> inputOfWinningNumber() {
        String userInput = Console.readLine();
        System.out.println();
        return Arrays.stream(userInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int inputOfBonusNumber(Lotto lotto) {
        String userInput = Console.readLine();
        System.out.println();
        return Integer.parseInt(userInput);
    }
}
