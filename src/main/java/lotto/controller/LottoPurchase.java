package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

public class LottoPurchase {
    public static final int LOTTO_PRICE = 1000;

    private int getPurchaseAmountInput() {
        String userInput = Console.readLine();
        int purchaseAmount = userInputIsNumber(userInput);
        lottoPriceUnitsValidate(purchaseAmount);

        return purchaseAmount;
    }

    private int purchaseAmountDividedByLottoPrice(int purchaseAmount) {
        lottoPriceUnitsValidate(purchaseAmount);
        return purchaseAmount / LOTTO_PRICE;
    }

    private int userInputIsNumber(String userInput) {
        if (!userInput.matches("[0-9]*")) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자만 입력할수 있습니다.");
        }

        return Integer.valueOf(userInput);
    }

    private void lottoPriceUnitsValidate(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 " + LOTTO_PRICE + "원 단위로 입력 가능합니다.");
        }
    }
}
