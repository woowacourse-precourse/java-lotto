package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.GuideMessage;

import java.util.HashSet;

public class Input {

    public String scanMoneyInput() {
        System.out.println(GuideMessage.MONEY_INPUT_MESSAGE.getGuideMessage());
        String money = Console.readLine();
        System.out.println();
        return money;
    }

    public String scanWinnerNumbers() {
        System.out.println(GuideMessage.PICK_WINNER_NUMBER_MESSAGE.getGuideMessage());
        String winningNumbers = Console.readLine();
        System.out.println();
        return winningNumbers;
    }

    public String scanBonusNumber() {
        System.out.println(GuideMessage.PICK_BONUS_NUMBER_MESSAGE.getGuideMessage());
        String bonusNumber = Console.readLine();
        System.out.println();
        return bonusNumber;
    }
}
