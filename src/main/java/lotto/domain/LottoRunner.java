package lotto.domain;

import java.util.List;
import lotto.ui.LottoInStream;
import lotto.ui.LottoOutStream;

public class LottoRunner {
    public static void run() {
        try {
            int money = LottoInStream.readAmount();
            List<Lotto> lottoes = LottoGame.buyLotto(money);
            LottoOutStream.showLottoList(lottoes);

            Lotto winningLotto = new Lotto(LottoInStream.readLottoNumbers());
            int bonusNumber = LottoInStream.readBonusNumber(winningLotto);

            int[] matches = LottoGame.getResult(lottoes, winningLotto, bonusNumber);

            LottoOutStream.showLottoResult(matches);
            LottoOutStream.showROR(LottoGame.getROR(matches, money));
        } catch (IllegalArgumentException ex) {
            System.out.print(ex.getMessage());
        }
    }
}
