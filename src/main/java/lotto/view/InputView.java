package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입 금액을 입력해주세요.";

    public static String inputMoneyByUser(){
        System.out.println(INPUT_MONEY_MESSAGE);
        String userMoney = Console.readLine();
        return userMoney;
    }
}
