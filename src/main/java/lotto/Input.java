package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    // 상수는 추후 application으로 이동
    private final static String ENTER_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String ENTER_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final static String ENTER_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static final String submit(String message) {
        System.out.println(message);
        String inputValue = Console.readLine();
        System.out.println();
        return inputValue;
    }
}
