package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String inputMoneyMessage = "구입금액을 입력해 주세요.";
    private static final String inputWinNumberMessage = "당첨 번호를 입력해 주세요.";
    private static final String inputBonusNumberMessage = "보너스 번호를 입력해 주세요.";

    public static String inputMoney() {
        System.out.println(inputMoneyMessage);
        return Console.readLine();
    }

    public static String inputWinNumber() {
        System.out.println(inputWinNumberMessage);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(inputBonusNumberMessage);
        return Console.readLine();
    }
}
