package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String REQUIRE_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String REQUIRE_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String REQUIRE_BONUS_NUMBER = "보너스 번호를 입력해주세요.";

    public String readMoney() {
        System.out.println(REQUIRE_INPUT_MONEY);
        return Console.readLine();
    }

    public String readWinningNumbers() {
        System.out.println(REQUIRE_WINNING_NUMBERS);
        return Console.readLine();
    }

    public String readBonusNumber() {
        System.out.println(REQUIRE_BONUS_NUMBER);
        return Console.readLine();
    }
}
