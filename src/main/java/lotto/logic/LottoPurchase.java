package lotto.logic;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionValidation;

public class LottoPurchase {

    public int puchaseLotto() {
        int amount = inputAmount();
        ExceptionValidation.validateException(amount);
        System.out.println(amount / 1000 + "개를 구매했습니다.");
        return amount;
    }

    private int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return ExceptionValidation.isNumber(input);
    }
}


