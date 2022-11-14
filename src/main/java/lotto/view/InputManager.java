package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    private static final String INPUT_MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ERROR_MESSAGE_NOT_INT = "[ERROR] 숫자만 입력 가능합니다.";
    private static final String ERROR_MESSAGE_NOT_PROPER_AMOUNT = "[ERROR] 구입 금액은 1000원 단위로 입력할 수 있습니다.";

    private InputManager() {
    }

    private int readPurchaseAmount() {
        printInputMessagePurchaseAmount();

        String inputAmount = Console.readLine();
        int intAmount = convertIntoIntAmount(inputAmount);
        validateInputAmount(intAmount);
        return intAmount;
    }

    private int convertIntoIntAmount(String inputAmount) {
        int intAmount;
        try {
            intAmount = Integer.parseInt(inputAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return intAmount;
    }

    private void validateInputAmount(int inputAmount) {
        if (inputAmount < 1000) {
            throw new IllegalArgumentException();
        }
        if (inputAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void printInputMessagePurchaseAmount() {
        System.out.println(INPUT_MESSAGE_PURCHASE_AMOUNT);
    }
}
