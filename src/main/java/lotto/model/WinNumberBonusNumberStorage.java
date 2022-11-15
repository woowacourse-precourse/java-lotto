package lotto.model;


import java.util.List;
import lotto.Lotto;
import lotto.controller.ExceptionHandler;
import lotto.view.WinNumberReceiver;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class WinNumberBonusNumberStorage {

    private static List<Integer> winNumber;

    public static void setWinNumber() {
        Lotto lotto = new Lotto(WinNumberReceiver.receiveWinNumber());
        ExceptionHandler.validateWinNumber(lotto.getNumbers());
        winNumber = lotto.getNumbers();
    }

    public static int receiveBonusNumber() {
        int bonusNumber = Integer.parseInt(readLine());
        ExceptionHandler.validateBonusNumber(bonusNumber);
        return Integer.parseInt(readLine());
    }
}
