package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String INPUT_LOTTO_AMOUNT= "구입금액을 입력해 주세요.";

    private InputView() {
    }

    public static String purchaseMessage() {
        System.out.println(INPUT_LOTTO_AMOUNT);
        return readLine();
    }
}
