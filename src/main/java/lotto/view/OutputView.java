package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

import static lotto.view.printer.OutputPrinter.printBuyInformMessage;

public class OutputView {
    public static void printUserLottos(List<Lotto> userLottos){
        printBuyInformMessage(userLottos.size());
        for(Lotto lotto : userLottos){
            System.out.println(lotto.toString());
        }
    }
}