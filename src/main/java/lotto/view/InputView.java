package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String AMOUNT_PHRASE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_PHRASE = "당첨 번호를 입력해 주세요.";

    public static String amount() {
        System.out.println(AMOUNT_PHRASE);
        String input = readLine();
        return input;
    }

    public static String winningNumber() {
        System.out.println(WINNING_NUMBER_PHRASE);
        String input = readLine();
        return input;
    }

}
