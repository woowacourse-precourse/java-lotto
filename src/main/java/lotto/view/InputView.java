package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.constant.MessageConstant.*;

public class InputView {
    public String inputPurchaseAmount() {
        System.out.println(INPUT_MESSAGE.getMessage());
        String purchaseAmount = Console.readLine();
        return purchaseAmount;
    }

    public String inputWinNumber() {
        System.out.println(WIN_MESSAGE.getMessage());
        String winNumber = Console.readLine();
        return  winNumber;
    }

    public String inputBonusNumber() {
        System.out.println(BONUS_MESSAGE.getMessage());
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
