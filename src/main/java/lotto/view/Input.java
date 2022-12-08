package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String getMoney() {
        String money = Console.readLine().trim();
        return money;
    }

    public String getWinningNumber() {
        Output.printWinningNumberInputMessage();
        String winningNumber = Console.readLine();
        return winningNumber;
    }

    public String getBonusNumber() {
        Output.printBonusNumberInputMessage();
        String bonusNumber = Console.readLine().trim();
        return bonusNumber;
    }
}
