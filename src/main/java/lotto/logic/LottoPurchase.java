package lotto.logic;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionValidation;

public class LottoPurchase {

    public int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int result = Integer.parseInt(input);
        return result;
    }

    public int puchaseLotto() {
        int amount = inputAmount();
        ExceptionValidation.validateException(amount);
        return amount / 1000;
    }
}


