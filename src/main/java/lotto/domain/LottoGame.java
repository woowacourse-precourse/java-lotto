package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
    public int GetUserInput() {
        String userInput = Console.readLine();
        return UserInputCheck.purchaseAmountCheck(userInput);
    }
}
