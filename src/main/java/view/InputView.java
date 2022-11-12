package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public int inputMoney() {
        System.out.println(INPUT_MONEY);
        String stringMoney = Console.readLine();
        int money = Integer.parseInt(stringMoney);
        return money;
    }

    public String inputWinningNumber() {
        String winningNumber = Console.readLine();
        return winningNumber;
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String StringBonusNumber = Console.readLine();
        int bonusNumber = Integer.parseInt(StringBonusNumber);
        return bonusNumber;
    }
}
