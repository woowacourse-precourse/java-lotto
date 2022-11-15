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
        Machine machine = new Machine();
        Console console = new Console();

        int count = console.inputCellCount();
        List<Lotto> lottos = machine.draw(count);
        System.out.println(lottos);

        WinningNumber winningNumber = console.inputWinningNumber();
        System.out.println(winningNumber);

        Map<Rank, Integer> rankings = machine.checkRanking(winningNumber, lottos.toArray(new Lotto[0]));
        System.out.println(rankings);
    }


}
