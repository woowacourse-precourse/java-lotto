package lotto.model;


import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.controller.ExceptionHandler;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class WinNumberBonusNumberReceiver {

    protected static Lotto receiveWinNumber() {
        Lotto lotto = new Lotto(Arrays.stream(readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
        ExceptionHandler.validateWinNumber(lotto.getNumbers());
        return lotto;
    }

    protected static int receiveBonusNumber() {
        int bonusNumber = Integer.parseInt(readLine());
        ExceptionHandler.validateBonusNumber(bonusNumber);
        return Integer.parseInt(readLine());
    }
}
