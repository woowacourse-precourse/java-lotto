package lotto.service;

import camp.nextstep.edu.missionutils.Console;

public class InputService {

    public static String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public String readWinningNumber() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public String readBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }

}
