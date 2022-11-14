package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.NoticeMessage;

public class InputView {
    public String inputPurchasingAmount() {
        return printMessage(NoticeMessage.PURCHASING_AMOUNT);
    }

    public String inputLuckyNumber() {
        return printMessage(NoticeMessage.LUCKY_NUMBER);
    }

    private String printMessage(NoticeMessage luckyNumber) {
        System.out.println(luckyNumber);
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    public String inputBonusNumber() {
        return printMessage(NoticeMessage.BONUS_NUMBER);
    }
}
