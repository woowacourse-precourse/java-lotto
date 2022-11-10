package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static final String INVALID_AMOUNT_ERROR_MESSAGE = "[ERROR] 올바른 금액을 입력해주세요.";
    public static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자만 입력해주세요.";

    public static void main(String[] args) {
        enterAmount();
    }

    private static void enterAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        isValidAmount(Console.readLine());
    }

    public static void isValidAmount(String enterValue) {
        for (int i = 0; i < enterValue.length(); i++) {
            if (!('0' <= enterValue.charAt(i) && enterValue.charAt(i) <= '9')) {
                throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
            }
        }
        if (Integer.parseInt(enterValue) % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_ERROR_MESSAGE);
        }
    }

}
