package view;

import camp.nextstep.edu.missionutils.Console;

import static util.StringUtil.parseToInt;

public class InputView {
    public static final String INPUT_BUY_AMOUNT = "구입 금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBER = "당첨번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static String inputMoney() {
        System.out.println(INPUT_BUY_AMOUNT);
        return Console.readLine();
    }

    public static String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return parseToInt(Console.readLine());
    }

}
