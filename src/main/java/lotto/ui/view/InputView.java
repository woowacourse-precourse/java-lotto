package lotto.ui.view;

import camp.nextstep.edu.missionutils.Console;

public enum InputView {
    INSTANCE;
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_JACKPOT_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        String money = Console.readLine();

        return money;
    }

    public static String inputJackpotNumbers() {
        System.out.println(INPUT_JACKPOT_NUMBERS_MESSAGE);
        String jackpotInput = Console.readLine();

        return jackpotInput;
    }

    public static String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String bonusInput = Console.readLine();

        return bonusInput;
    }
}
