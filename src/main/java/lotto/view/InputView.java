package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Messages;

public class InputView {
    public static String inputMoney() {
        System.out.printf(Messages.INPUT_MONEY.get());
        return Console.readLine();
    }

    public static String inputWinLotto() {
        System.out.printf(Messages.INPUT_WIN_LOTTO_NUM.get());
        return Console.readLine();
    }

    public static String inputBonusNum() {
        System.out.printf(Messages.INPUT_WIN_BONUS_NUM.get());
        return Console.readLine();
    }
}
