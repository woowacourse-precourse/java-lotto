package controller;

import camp.nextstep.edu.missionutils.Console;
import common.message.Message;

public class Input {

    public static String inputAmount() {
        System.out.println(Message.TOTAL_FUND.getValue());
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(Message.INPUT_LOTTO_NUMBER.getValue());
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(Message.INPUT_BONUS_NUMBER.getValue());
        return Console.readLine();
    }
}
