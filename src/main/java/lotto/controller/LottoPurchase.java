package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

public class LottoPurchase {
    private String getPurchaseAmountInput() {
        return Console.readLine();
    }

    private void userInputIsNumber(String userInput) {
        if (!userInput.matches("[0-9]*")) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자만 입력할수 있습니다.");
        }
    }
}
