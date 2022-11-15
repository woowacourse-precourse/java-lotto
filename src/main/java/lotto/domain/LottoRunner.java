package lotto.domain;

import java.util.List;
import lotto.ui.LottoInStream;
import lotto.ui.LottoOutStream;

public class LottoRunner {
    public static void run() {
        try {
            int money = LottoInStream.readAmount();
            List<Lotto> lotto = LottoGame.buy(money);
            LottoOutStream.showLottoList(lotto);

            Lotto winningLotto = new Lotto(LottoInStream.readLottoNumbers());
            int bonusNumber = LottoInStream.readBonusNumber(winningLotto);

            int[] matchTable = LottoGame.getResult(lotto, winningLotto, bonusNumber);

            LottoOutStream.showResult(matchTable);
            LottoOutStream.showROR(matchTable, money);
        } catch (IllegalArgumentException ex) {
            System.out.print(ex.getMessage());
        }
    }
}
