package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String ASK_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String ASK_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String ASK_BONUS_NUMBER_MESSAGE = "보너스 번호 입력해 주세요.";

    public static String getInput() {
        String input = Console.readLine();
        return input;
    }

    public static String getMoney() {
        System.out.println(ASK_MONEY_MESSAGE);
        String input = InputView.getInput();
        return input;
    }

    public static String getNumbers() {
        System.out.println(ASK_WINNING_NUMBER_MESSAGE);
        String input = InputView.getInput();
        return input;
    }

    public static String getNumber() {
        System.out.println(ASK_BONUS_NUMBER_MESSAGE);
        String input = InputView.getInput();
        return input;
    }
}