package lotto.io;

import java.util.List;
import lotto.model.Lotto;

public interface Output {
    void printPurchasePrompt();

    void printWinningNumberPrompt();

    void printBonusNumberPrompt();

    void printLottos(int count, List<Lotto> lottos);

    void printResult(List<Integer> winningCounts, double yield);

    void printError(Exception e);
}
