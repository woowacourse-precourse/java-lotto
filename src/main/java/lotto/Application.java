package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final String MONEY_TYPE_ERROR_MESSAGE = "[ERROR] 숫자가 아닌 값을 입력하였습니다.";
    private static final String MONEY_UNIT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000원 단위입니다.";

    public static void main(String[] args) {
        int inputMoney = 0;
        String userInput = Console.readLine();

        try {
            inputMoney = Integer.parseInt(userInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(MONEY_TYPE_ERROR_MESSAGE);
        }

        if (inputMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MONEY_UNIT_ERROR_MESSAGE);
        }
    }
}
