package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";

    public static String inputMoney() {
        System.out.println(INPUT_MONEY);
        return Console.readLine();
    }

    public static String inputWinningLottoNumbers() {
        System.out.println(INPUT_WINNING_LOTTO_NUMBERS);
        return Console.readLine();
    }
}
