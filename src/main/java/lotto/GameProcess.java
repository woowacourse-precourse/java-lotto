package lotto;

import lotto.domain.Lotto;
import lotto.domain.Service;

public class GameProcess {
    public static void gameStart() {
        Service.inputMoney();
        Lotto.inputWinningNumbers();
    }
}
