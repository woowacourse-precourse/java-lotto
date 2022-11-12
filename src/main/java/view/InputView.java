package view;

import camp.nextstep.edu.missionutils.Console;
import model.NoticeMessage;

import static model.NoticeMessage.LUCKY_NUMBER;
import static model.NoticeMessage.PURCHASING_AMOUNT;

public class InputView {
    public String inputMoney() {
        return printMessage(PURCHASING_AMOUNT);
    }

    public String inputLuckyNumber() {
        return printMessage(LUCKY_NUMBER);
    }

    private String printMessage(NoticeMessage luckyNumber) {
        System.out.println(luckyNumber);
        String input = Console.readLine();
        System.out.println();
        return input;
    }

}
