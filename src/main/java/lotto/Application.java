package lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Machine;
import lotto.domain.ui.Printer;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Machine machine = new Machine();
        Printer printer = new Printer();

        int cellAmount = printer.inputCellAmount();
        List<Lotto> lottos = machine.draw(cellAmount);




    }


}
