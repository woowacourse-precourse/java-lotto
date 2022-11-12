package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.Constants.*;

public class InputView {
    final String INPUT_MONEY = "구입 금액을 입력해 주세요.";
    final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String inputMoney() {
        System.out.println(INPUT_MONEY);
        return readLine();
    }

    public String inputWinningNumbers() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBERS);
        return readLine();
    }

    public String inputBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER);
        return readLine();
    }
}
