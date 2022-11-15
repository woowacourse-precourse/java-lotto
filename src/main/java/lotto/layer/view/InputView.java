package lotto.layer.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView extends View{
    private static final String REQUEST_MONEY = "구입금액을 입력해 주세요.";
    private static final String REQUEST_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String requestMoney() {
        print(REQUEST_MONEY);
        String input = Console.readLine();
        printEmptyLine();
        return input;
    }

    public String requestLotto() {
        print(REQUEST_LOTTO_NUMBER);
        String input = Console.readLine();
        printEmptyLine();
        return input;
    }

    public String requestBonusNumber() {
        print(REQUEST_BONUS_NUMBER);
        String input = Console.readLine();
        printEmptyLine();
        return input;
    }
}