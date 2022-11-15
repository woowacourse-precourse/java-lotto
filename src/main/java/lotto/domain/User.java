package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InvalidUserInputException;

public class User {

    private int amount = 0; // 구입 금액

    public void enterLottoBuyAmount() {
        amount = Integer.valueOf(Console.readLine());

        if(amount % 1000 != 0) {
            throw new InvalidUserInputException("1000원 단위로 입력하셔야 합니다.");
        }
    }

    public int getGameCount() {
        return amount / 1000;
    }

}
