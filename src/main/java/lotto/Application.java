package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.ui.LottoInStream;
import lotto.ui.LottoOutStream;

public class Application {
    private static final String _error = "[ERROR]";

    public static void main(String[] args) {
        int money = LottoInStream.readAmount();
        List<Lotto> lottoes = LottoGame.buyLotto(money);
        LottoOutStream.showLottoList(lottoes);

        Lotto winningLotto = new Lotto(LottoInStream.readLottoNumbers());
        int bonusNumber = LottoInStream.readBonusNumber(winningLotto);

        int[] matches = LottoGame.getResultLotto(lottoes, winningLotto, bonusNumber);

        LottoOutStream.showLottoResult(matches);
        LottoOutStream.showRateOfReturn(LottoGame.calcRateOfReturn(matches, money));
    }

    public static void lottoError(String error_msg) {
        throw new IllegalArgumentException(_error + " " + error_msg);
    }
}
