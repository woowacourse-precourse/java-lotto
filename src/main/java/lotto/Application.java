package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.view.LottoManager;

public class Application {
    public static void main(String[] args) {
        final LottoManager lottoManager = new LottoManager();
        try {
            final int lottoCount = lottoManager.inputPurchaseMoney();
            lottoManager.printLottoCount(lottoCount);

            final NumberGenerator numberGenerator = new NumberGenerator();
            List<Lotto> lottos = new ArrayList<>(lottoCount);
            for (int i = 0; i < lottoCount; i++) {
                lottos.add(i, new Lotto(numberGenerator.createLottoNumbers()));
            }
//            Lotto[] lottos = new Lotto[lottoCount];
//            for (int i = 0; i < lottos.length; i++) {
//                lottos[i] = new Lotto(numberGenerator.createLottoNumbers());
//            }
            lottoManager.printLottoNumbers(lottos);

            List<Integer> winningNumbers = numberGenerator.createWinningNumbers(lottoManager.inputWinningNumbers());
            WinningNumbers w = new WinningNumbers(winningNumbers);
            final int bonusNumber = numberGenerator.createBonusNumbers(winningNumbers, lottoManager.inputBonusNumber());

            LottoCalculator lottoCalculator = new LottoCalculator();
            for (Lotto lotto : lottos) {
                int correctCount = lottoCalculator.compare(lotto, w, bonusNumber);
                lottoCalculator.addRankCount(correctCount);
            }

            lottoManager.printWinningDetails(lottoCalculator.getRankCount());
            lottoManager.printRateOfReturn(lottoCalculator);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
        }
    }
}
