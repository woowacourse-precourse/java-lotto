package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    private static final String AMOUNT_INPUT_MSG = "구입금액을 입력해 주세요";

    private static final String AMOUNT_ERROR_MSG = "[ERROR] 잘못된 금액 값을 입력했습니다.";

    public int amountInput() {
        System.out.println(AMOUNT_INPUT_MSG);

        String str = Console.readLine();

        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            throw new IllegalArgumentException(AMOUNT_ERROR_MSG);
        }
    }
}
