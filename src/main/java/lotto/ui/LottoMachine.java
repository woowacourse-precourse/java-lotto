package lotto.ui;

import lotto.Lotto;
import lotto.ui.InputScanner;
import lotto.domain.LottoComparator;
import lotto.domain.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    InputScanner scanner = new InputScanner();
    List<Lotto> lottos = new ArrayList<>();

    public LottoMachine() {
    }

    public void start() {
        purchaseLottos();
        Printer.printPurchasedLottos(lottos);
        Printer.requestWinningNumber();
        List<Integer> winningNumbers = scanner.scanWinningNumbers();

        Printer.requestBonusNumber();
        int bonusNumber = scanner.scanBonusNumber();
    }

    private void purchaseLottos() {
        int lottoCount = scanner.scanPurchaseAmount();
        Printer.requestLottoCount(lottoCount);
        NumberGenerator numberGenerator = new NumberGenerator();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(numberGenerator.createRandomNumbers());
            lottos.add(lotto);
        }
    }
}
