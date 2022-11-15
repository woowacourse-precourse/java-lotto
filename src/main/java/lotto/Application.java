package lotto;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.view.LottoManager;

public class Application {
    public static void main(String[] args) {
        final LottoManager lottoManager = new LottoManager();
        final LottoCalculator lottoCalculator = new LottoCalculator();
        try {
            final int lottoCount = lottoManager.inputPurchaseMoney();
            lottoManager.printLottoCount(lottoCount);
            Lottos lottos = new Lottos(lottoCount);
            lottoManager.printLottoNumbers(lottos.getLottos());
            WinningNumbers winningNumbers = new WinningNumbers(lottoManager.inputWinningNumbers(), lottoManager.inputBonusNumber());

            for (Lotto lotto : lottos.getLottos()) {
                lottoCalculator.addRankCount(lottoCalculator.compare(lotto.getNumbers(), winningNumbers.getNumbers(), winningNumbers.getBonusNumber()));
            }
            lottoManager.printWinningDetails(lottoCalculator.getRankCount(), lottoCalculator.RateOfReturn(getPurchaseMoney(lottoCount)));
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
        }
    }

    public static int getPurchaseMoney(int lottoCount) {
        return lottoCount * 1000;
    }
}
