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
        int result = 0;
        int amount = inputAmount();
        ExceptionValidation.validateException(amount);
        result = amount / 1000;
        System.out.println(result+"개를 구매했습니다.");
        return result;
    }
}


