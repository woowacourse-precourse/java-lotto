package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

import static lotto.view.printer.OutputPrinter.*;

public class OutputView {
    public static void printUserLottos(List<Lotto> userLottos) {
        printBuyInformMessage(userLottos.size());
        for (Lotto lotto : userLottos) {
            printLottoNumbers(lotto);
        }
    }
}