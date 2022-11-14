package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.view.LottoManager;

public class Application {
    public static void main(String[] args) {
        final LottoManager lottoManager = new LottoManager();
        final LottoCalculator lottoCalculator = new LottoCalculator();
        final NumberGenerator numberGenerator = new NumberGenerator();

        try {
            final int lottoCount = lottoManager.inputPurchaseMoney();
            lottoManager.printLottoCount(lottoCount);

//            List<Lotto> lottos = new ArrayList<>(lottoCount);
//            for (int i = 0; i < lottoCount; i++) {
//                lottos.add(i, new Lotto(numberGenerator.createLottoNumbers()));
//            }
            Lottos lottos = new Lottos(lottoCount);
            lottoManager.printLottoNumbers(lottos.getLottos());

            List<Integer> winningNumbers = numberGenerator.createWinningNumbers(lottoManager.inputWinningNumbers());
            WinningNumbers w = new WinningNumbers(winningNumbers);
            final int bonusNumber = numberGenerator.createBonusNumbers(winningNumbers, lottoManager.inputBonusNumber());

            for (Lotto lotto : lottos.getLottos()) {
                int correctCount = lottoCalculator.compare(lotto.getNumbers(), w.getNumbers(), bonusNumber);
                lottoCalculator.addRankCount(correctCount);
            }

            lottoManager.printWinningDetails(lottoCalculator.getRankCount());
            lottoManager.printRateOfReturn(lottoCalculator.RateOfReturn(lottoManager.getPurchaseMoney()));
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
        }
    }
}
