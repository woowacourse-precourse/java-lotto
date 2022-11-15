package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입 금액을 입력해주세요";


    public static String inputMoneyView() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return inputMoney(Console.readLine());
    }

    private static String inputMoney(String input) {
        return input;
    }
}
