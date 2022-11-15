package lotto.io;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningStatus;

public interface Output {
    void printPurchasePrompt();

    void printWinningNumberPrompt();

    void printBonusNumberPrompt();

    void printLottos(int count, List<Lotto> lottos);

    void printResult(WinningStatus winningStatus);

    void printError(Exception e);
}
