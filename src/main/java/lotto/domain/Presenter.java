package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

import static lotto.exception.InputException.*;

public class Presenter {
    public static List<Integer> inputWinLottoNumber() {
        String winLottoNumber = Console.readLine();
        return validatesWinLottoNumber(winLottoNumber);
    }

    public static int inputBonusNumber() {
        String bonusNumber = Console.readLine();
        return validatesBonusNumber(bonusNumber);
    }
}
