package lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Machine;
import lotto.domain.lotto.Rank;
import lotto.domain.lotto.WinningNumber;
import lotto.domain.ui.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConsoleTest {

    @DisplayName("결과 출력")
    @Test
    void printResult() {
        Machine machine = new Machine();
        List<Lotto> lottos = new ArrayList<>();

        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(winLotto, bonusNumber);
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        lottos.add(lotto1);
        Lotto lotto2 = new Lotto(List.of(5, 6, 7, 8, 9, 10));
        lottos.add(lotto2);

        Map<Rank, Integer> rankings = machine.checkRanking(winningNumber, lottos.toArray(new Lotto[0]));
        double yieldRate = machine.calculateYieldRate(rankings);

        Console console = new Console();
        console.printResult(rankings, yieldRate);
    }
}
