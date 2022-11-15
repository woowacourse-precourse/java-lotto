package lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Machine;
import lotto.domain.lotto.Rank;
import lotto.domain.lotto.WinningNumber;
import lotto.domain.ui.Console;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        try {
            Machine machine = new Machine();
            Console console = new Console();

            int count = console.inputCellCount();
            List<Lotto> lottos = machine.draw(count);
            console.printBuyLottos(lottos);

            WinningNumber winningNumber = console.inputWinningNumber();

            Map<Rank, Integer> rankings = machine.checkRanking(winningNumber, lottos.toArray(new Lotto[0]));

            double yieldRate = machine.calculateYieldRate(rankings);
            console.printResult(rankings, yieldRate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
