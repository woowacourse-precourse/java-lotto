package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String TYPE_ERROR = "[ERROR] 숫자만 입력 가능합니다.";

    private InputView() {
    }

    public static int inputAmount() {
        System.out.println(INPUT_LOTTO_AMOUNT);
        return convertToInt(Console.readLine());
    }

    private static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TYPE_ERROR);
        }
    }

}
