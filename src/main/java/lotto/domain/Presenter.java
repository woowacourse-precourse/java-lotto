package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputException;

import java.util.List;

public class Presenter {
    public static List<Integer> inputWinLottoNumber() {
        String winLottoNumber = Console.readLine();
        return InputException.validatesWinLottoNumber(winLottoNumber);
    }

    public static String inputBonusNumber() {
        return Console.readLine();
    }
}
