package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입 금액을 입력해주세요.";
    private static final String INPUT_WINNiNG_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String inputMoneyByUser(){
        System.out.println(INPUT_MONEY_MESSAGE);
        String userMoney = Console.readLine();
        return userMoney;
    }

    public static String inputWinningNumbers(){
        System.out.println(INPUT_WINNiNG_NUMBERS_MESSAGE);
        String winningNumbers = Console.readLine();
        return winningNumbers;
    }

    public static String inputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
