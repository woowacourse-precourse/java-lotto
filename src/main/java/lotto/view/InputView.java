package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String BUYING_PRICE = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String inputPrice() {
        System.out.println(BUYING_PRICE);
        return Console.readLine();
    }

    public String inputWinningNumber() {
        System.out.println(WINNING_NUMBER);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println();
        System.out.println(BONUS_NUMBER);
        return Console.readLine();
    }
}
