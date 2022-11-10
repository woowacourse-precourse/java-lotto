package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_PRICE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String DATA_TYPE_ERR_MESSAGE = "[ERROR] 숫자가 아닙니다.";

    public InputView() {
    }

    public static int getPriceAmount() {
        System.out.println(INPUT_PRICE_AMOUNT);
        return convertStringtoInt(Console.readLine());
    }

    private static int convertStringtoInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DATA_TYPE_ERR_MESSAGE);
        }
    }
}