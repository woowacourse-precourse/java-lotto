package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Message;
import lotto.domain.Money;

public class InputView {

    public static String inputMoney() {
        System.out.printf(Message.INPUT_MONEY.get());
        return Console.readLine();
    }

    public static String inputWinLottoNumber() {
        System.out.println();
        System.out.printf(Message.INPUT_WIN_LOTTONUMBER.get());
        return Console.readLine();
    }

    public static String inputBonusLottoNumber(){
        System.out.println();
        System.out.printf(Message.INPUT_BONUS_LOTTONUMBER.get());
        return Console.readLine();
    }
}
