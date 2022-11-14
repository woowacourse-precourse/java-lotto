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
        System.out.println("\n" + "당첨 번호를 입력해주세요.");
        List<Integer> winningNumbers = scanner.scanWinningNumbers();

        System.out.println("\n" + "보너스 번호를 입력해주세요.");
        int bonusNumber = scanner.scanBonusNumber();
    }

    private void purchaseLottos() {
        int lottoCount = scanner.scanPurchaseAmount();
        NumberGenerator numberGenerator = new NumberGenerator();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(numberGenerator.createRandomNumbers());
            lottos.add(lotto);
        }
    }
}
