package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String inputPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        return purchaseAmount;
    }

    public static String inputWinNumber() {
        String winNumber = Console.readLine();
        return winNumber;
    }

    public static String inputBonusNumber() {
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
