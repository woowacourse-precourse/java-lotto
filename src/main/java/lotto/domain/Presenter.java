package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

import static lotto.exception.InputException.*;
import static lotto.view.InputView.inputBonusNumberMessage;
import static lotto.view.InputView.inputWinLottoNumberMessage;

public class Presenter {
    public static List<Integer> inputWinLottoNumber() {
        inputWinLottoNumberMessage();
        String winLottoNumber = Console.readLine();
        return validatesWinLottoNumber(winLottoNumber);
    }

    public static int inputBonusNumber() {
        inputBonusNumberMessage();
        String bonusNumber = Console.readLine();
        return validatesBonusNumber(bonusNumber);
    }
}
